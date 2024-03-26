package com.techno.springbootdasar.service.impl

import com.techno.springbootdasar.domain.dto.req.ReqPerhitunganDto
import com.techno.springbootdasar.domain.dto.res.ResBiodataDto
import com.techno.springbootdasar.domain.dto.res.ResHasilDto
import com.techno.springbootdasar.service.PerhitunganService
import org.springframework.stereotype.Service

@Service
class PerhitunganServiceImpl : PerhitunganService {
    override fun penjumlahan(response: ReqPerhitunganDto): ResHasilDto {

        val response = ResHasilDto(
            hasil = response.angka1 + response.angka2
        )
        return response
    }

    override fun pengurangan(response: ReqPerhitunganDto): ResHasilDto {
        val response = ResHasilDto(
            hasil = response.angka1 - response.angka2
        )
        return response
    }

    override fun perkalian(response: ReqPerhitunganDto): ResHasilDto {
        val response = ResHasilDto(
            hasil = response.angka1 * response.angka2
        )
        return response
    }

    override fun pembagian(response: ReqPerhitunganDto): ResHasilDto {
        val response = ResHasilDto(
            hasil = response.angka1 / response.angka2
        )
        return response
    }
}