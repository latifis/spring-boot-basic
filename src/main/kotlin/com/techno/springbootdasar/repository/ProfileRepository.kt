package com.techno.springbootdasar.repository

import com.techno.springbootdasar.domain.entity.ProfileEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ProfileRepository : JpaRepository<ProfileEntity, UUID> {

    fun findByUsername(username: String?): ProfileEntity?

    fun findByEmail(email: String?): ProfileEntity?
}