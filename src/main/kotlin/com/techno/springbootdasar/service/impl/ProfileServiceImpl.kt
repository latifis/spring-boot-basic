package com.techno.springbootdasar.service.impl

import com.techno.springbootdasar.domain.dto.req.ReqProfileDto
import com.techno.springbootdasar.domain.dto.res.ResGetMotorDto
import com.techno.springbootdasar.domain.dto.res.ResMessageDto
import com.techno.springbootdasar.domain.dto.res.ResProfileDto
import com.techno.springbootdasar.domain.entity.MotorEntity
import com.techno.springbootdasar.domain.entity.ProfileEntity
import com.techno.springbootdasar.exception.DataNotFoundException
import com.techno.springbootdasar.repository.ProfileRepository
import com.techno.springbootdasar.service.ProfileService
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProfileServiceImpl (
    val profileRepository: ProfileRepository
) : ProfileService{
    override fun insert(req: ReqProfileDto): ResMessageDto<String> {
        val insert = ProfileEntity(
            id = UUID.randomUUID(),
            name = req.name,
            username = req.username,
            email = req.email,
            password = req.password
        )
        profileRepository.save(insert)

        return ResMessageDto()
    }

    override fun update(uuid: UUID, req: ReqProfileDto): ResMessageDto<String> {
        TODO("Not yet implemented")
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
            password = checkId.get().password!!
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
                password = profile.password!!
            )
            responseList.add(data)
        }

        return ResMessageDto(data = responseList)
    }

    override fun delete(uuid: UUID): ResMessageDto<String> {
        TODO("Not yet implemented")
    }
}