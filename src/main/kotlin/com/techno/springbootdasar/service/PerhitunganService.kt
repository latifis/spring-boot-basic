package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.req.ReqPerhitunganDto
import com.techno.springbootdasar.domain.dto.res.ResHasilDto

interface PerhitunganService {
    fun penjumlahan(response: ReqPerhitunganDto) : ResHasilDto

    fun pengurangan(response: ReqPerhitunganDto) : ResHasilDto

    fun perkalian(response: ReqPerhitunganDto) : ResHasilDto

    fun pembagian(response: ReqPerhitunganDto) : ResHasilDto
}