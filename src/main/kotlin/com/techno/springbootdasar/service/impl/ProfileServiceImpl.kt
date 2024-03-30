package com.techno.springbootdasar.service.impl

import com.techno.springbootdasar.domain.dto.req.ReqProfileDto
import com.techno.springbootdasar.domain.dto.res.ResGetMotorDto
import com.techno.springbootdasar.domain.dto.res.ResMessageDto
import com.techno.springbootdasar.domain.dto.res.ResProfileDto
import com.techno.springbootdasar.domain.entity.MotorEntity
import com.techno.springbootdasar.domain.entity.ProfileEntity
import com.techno.springbootdasar.exception.DataExist
import com.techno.springbootdasar.exception.DataNotFoundException
import com.techno.springbootdasar.repository.ProfileRepository
import com.techno.springbootdasar.rest.AvatarApiClient
import com.techno.springbootdasar.service.ProfileService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProfileServiceImpl (
    val profileRepository: ProfileRepository,
    private val avatarApiClient: AvatarApiClient
) : ProfileService{
    override fun insert(seed: String?, req: ReqProfileDto): ResMessageDto<ResProfileDto> {

        val existingUsername = profileRepository.findByUsername(req.username)
        val existingEmail = profileRepository.findByEmail(req.email)

        if (existingEmail != null && existingUsername != null) {
            throw DataExist("Nama dan Email Profil Sudah Ada")
        } else if (existingEmail != null) {
            throw DataExist("Email Profil Sudah Ada")
        } else if (existingUsername != null) {
            throw DataExist("Username Profil Sudah Ada")
        } else {

            var seeder: String = ""

            if (!seed.isNullOrBlank()) {
                val responseEntity = avatarApiClient.getAvatar(seed = seed)
                val logger = LoggerFactory.getLogger("MyClass")
                logger.info("ResponseEntity: {}", responseEntity.body)
                if (responseEntity.statusCode.is2xxSuccessful) {
                    seeder = responseEntity.body ?: ""
                }
            }

            val insert = ProfileEntity(
                id = UUID.randomUUID(),
                name = req.name,
                username = req.username,
                email = req.email,
                password = req.password,
                avatar = seeder
            )
            val savedProfile = profileRepository.save(insert)
            val resProfileDto = ResProfileDto(
                id = savedProfile.id,
                name = savedProfile.name,
                username = savedProfile.username,
                email = savedProfile.email,
                avatar = savedProfile.avatar
            )
            return ResMessageDto(data = resProfileDto)
        }
    }

    override fun update(uuid: UUID, req: ReqProfileDto): ResMessageDto<ResProfileDto> {
        val checkId = profileRepository.findById(uuid)

        if(!checkId.isPresent)
            throw DataNotFoundException("ID Profile Tidak Ada")

        checkId.get().name = req.name
        checkId.get().password = req.password


        val updateProfile = profileRepository.save(checkId.get())
        val resProfileDto = ResProfileDto(
            id = updateProfile.id,
            name = updateProfile.name,
            username = updateProfile.username,
            email = updateProfile.email,
            avatar = updateProfile.avatar
        )
        return ResMessageDto(data = resProfileDto)
    }

    override fun detail(uuid: UUID): ResMessageDto<ResProfileDto> {
        val checkId = profileRepository.findById(uuid)

        if(!checkId.isPresent)
            throw DataNotFoundException("ID Profile Tidak Ada")

        val response = ResProfileDto(
            id = checkId.get().id!!,
            name = checkId.get().name!!,
            username = checkId.get().username!!,
            email = checkId.get().email!!,
            avatar = checkId.get().avatar!!
        )

        return ResMessageDto(data = response)
    }

    override fun list(): ResMessageDto<List<ResProfileDto>> {
        val profileList = profileRepository.findAll()

        val responseList = arrayListOf<ResProfileDto>()
        for (profile in profileList){
            val data = ResProfileDto(
                id = profile.id!!,
                name = profile.name!!,
                username = profile.username!!,
                email = profile.email!!,
                avatar = profile.avatar!!
            )
            responseList.add(data)
        }

        return ResMessageDto(data = responseList)
    }

    override fun delete(uuid: UUID): ResMessageDto<String> {
        val checkId = profileRepository.findById(uuid)

        if(!checkId.isPresent)
            throw DataNotFoundException("ID Profile Tidak Ada")

        profileRepository.deleteById(uuid)

        return ResMessageDto()
    }
}