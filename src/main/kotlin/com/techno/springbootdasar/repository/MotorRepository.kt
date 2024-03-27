package com.techno.springbootdasar.repository

import com.techno.springbootdasar.domain.entity.MotorEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface MotorRepository : JpaRepository<MotorEntity, UUID> {
}