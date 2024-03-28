package com.techno.springbootdasar.rest

import com.techno.springbootdasar.domain.dto.res.ResRandomImageDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(value = "DogApi", url = "https://dog.ceo/api/breeds")
interface DogApiClient {

    @GetMapping("/image/random")
    fun getRandomImage(): ResRandomImageDto

}