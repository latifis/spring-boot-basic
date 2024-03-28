package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.res.ResDogListDto
import com.techno.springbootdasar.domain.dto.res.ResMessageDto
import com.techno.springbootdasar.domain.dto.res.ResProfileDto
import com.techno.springbootdasar.domain.dto.res.ResRandomImageDto
import com.techno.springbootdasar.service.DogService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/v1/api/dog")
class DogController (
    val dogService: DogService
){

    @GetMapping("/random-image")
    fun getRandomDog(): ResRandomImageDto {
        return dogService.getDogImage()
    }

    @GetMapping("/list-image")
    fun getListDog(): ResDogListDto? {
        return dogService.getDogList()
    }
}