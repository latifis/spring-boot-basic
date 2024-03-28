package com.techno.springbootdasar.service.impl

import com.techno.springbootdasar.domain.dto.res.ResRandomImageDto
import com.techno.springbootdasar.rest.DogApiClient
import com.techno.springbootdasar.service.DogService
import org.springframework.stereotype.Service

@Service
class DogServiceImpl (
    private val dogApiClient: DogApiClient
): DogService {

    override fun getDogImage(): ResRandomImageDto {
        return dogApiClient.getRandomImage()

//        val dog = dogApiClient.getRandomImage()
//        return ResRandomImageDto(message = dog)
    }
}