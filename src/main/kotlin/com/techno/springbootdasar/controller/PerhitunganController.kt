package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.req.ReqNumberDto
import com.techno.springbootdasar.domain.dto.req.ReqPerhitunganDto
import com.techno.springbootdasar.domain.dto.res.ResBiodataDto
import com.techno.springbootdasar.domain.dto.res.ResHasilDto
import com.techno.springbootdasar.service.PerhitunganService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/api")
class PerhitunganController (
    val perhitunganService: PerhitunganService
) {
    @PostMapping("/penjumlahan")
    fun penjumlahan(@RequestBody request: ReqPerhitunganDto): ResponseEntity<ResHasilDto>{
        val response = perhitunganService.penjumlahan(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/pengurangan")
    fun pengurangan(@RequestBody request: ReqPerhitunganDto): ResponseEntity<ResHasilDto>{
        val response = perhitunganService.pengurangan(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/pembagian")
    fun pembagian(@RequestBody request: ReqPerhitunganDto): ResponseEntity<ResHasilDto>{
        val response = perhitunganService.pembagian(request)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/perkalian")
    fun perkalian(@RequestBody request: ReqPerhitunganDto): ResponseEntity<ResHasilDto>{
        val response = perhitunganService.perkalian(request)
        return ResponseEntity.ok(response)
    }
}