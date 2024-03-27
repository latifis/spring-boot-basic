package com.techno.springbootdasar.service.impl

import com.techno.springbootdasar.domain.dto.req.ReqInsertDto
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
}