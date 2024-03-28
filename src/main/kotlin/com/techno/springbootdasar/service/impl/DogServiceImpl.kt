package com.techno.springbootdasar.service.impl

import com.techno.springbootdasar.domain.dto.res.ResDogListDto
import com.techno.springbootdasar.domain.dto.res.ResRandomImageDto
import com.techno.springbootdasar.rest.DogApiClient
import com.techno.springbootdasar.service.DogService
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class DogServiceImpl (
    private val dogApiClient: DogApiClient,
    val restTemplate: RestTemplate = RestTemplateBuilder().build()
): DogService {

    override fun getDogImage(): ResRandomImageDto {
        return dogApiClient.getRandomImage()
//        val dog = dogApiClient.getRandomImage()
//        return ResRandomImageDto(message = dog)
    }

    override fun getDogList(): ResDogListDto? {
        val response: ResDogListDto? = restTemplate.getForObject(
            "https://dog.ceo/api/breeds/list/all",
            ResDogListDto::class.java
        )
        return response?.let { ResDogListDto( it.message,  it.status ) }
    }
}