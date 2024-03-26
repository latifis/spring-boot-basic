package com.techno.springbootdasar.service.impl

import com.techno.springbootdasar.domain.dto.res.ResBiodataDto
import com.techno.springbootdasar.service.BiodataService
import org.springframework.stereotype.Service

@Service
class BiodataServiceImpl : BiodataService{
    override fun getBiodata(): ResBiodataDto {
        val response = ResBiodataDto(
            firstName = "Latieff",
            lastName = "Irfann"
        )
        return response
    }
}