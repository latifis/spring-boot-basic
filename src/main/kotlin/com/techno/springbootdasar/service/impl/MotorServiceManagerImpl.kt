package com.techno.springbootdasar.service.impl

import com.techno.springbootdasar.domain.dto.req.ReqInsertDto
import com.techno.springbootdasar.domain.dto.res.ResMessageDto
import com.techno.springbootdasar.domain.entity.MotorEntity
import com.techno.springbootdasar.service.MotorServiceManager
import jakarta.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired

class MotorServiceManagerImpl : MotorServiceManager{

    @Autowired
    lateinit var entityManager: EntityManager

    override fun saveMotor(req: ReqInsertDto): ResMessageDto<String> {
        val motor = MotorEntity(nama = req.nama, merk = req.merk)
        entityManager.persist(motor)

        return ResMessageDto()
    }

}