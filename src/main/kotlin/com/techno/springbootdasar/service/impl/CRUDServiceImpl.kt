package com.techno.springbootdasar.service.impl

import com.techno.springbootdasar.domain.dto.req.ReqInsertDto
import com.techno.springbootdasar.domain.dto.res.ResGetMotorDto
import com.techno.springbootdasar.domain.dto.res.ResMessageDto
import com.techno.springbootdasar.domain.entity.MotorEntity
import com.techno.springbootdasar.repository.MotorRepository
import com.techno.springbootdasar.service.CRUDService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CRUDServiceImpl (
    val motorRepository: MotorRepository
) : CRUDService {
    override fun insert(req: ReqInsertDto): ResMessageDto<String> {
        val insert = MotorEntity(
            id = UUID.randomUUID(),
            nama = req.nama,
            merk = req.merk
        )
        motorRepository.save(insert)

        return ResMessageDto()
    }

    override fun update(uuid: UUID, req: ReqInsertDto): ResMessageDto<String> {
        val checkId = motorRepository.findById(uuid)

        checkId.get().nama = req.nama
        checkId.get().merk = req.merk

        motorRepository.save(checkId.get())

        return ResMessageDto()
    }

    override fun detail(uuid: UUID): ResMessageDto<ResGetMotorDto> {
        val checkId = motorRepository.findById(uuid)

        val response = ResGetMotorDto(
            id = checkId.get().id!!,
            name = checkId.get().nama!!,
            merk = checkId.get().merk!!
        )

        return ResMessageDto(data = response)
    }

    override fun list(): ResMessageDto<List<ResGetMotorDto>> {
        val motorList = motorRepository.findAll()

        val responseList = arrayListOf<ResGetMotorDto>()
        for (motor in motorList){
            val data = ResGetMotorDto(
                id = motor.id!!,
                name = motor.nama!!,
                merk = motor.merk!!
            )
            responseList.add(data)
        }

        return ResMessageDto(data = responseList)
    }

    override fun delete(uuid: UUID): ResMessageDto<String> {
        val deleted = motorRepository.deleteById(uuid)
        return ResMessageDto()
    }
}