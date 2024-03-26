package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.res.ResBiodataDto

interface BiodataService {
    fun getBiodata(): ResBiodataDto
}