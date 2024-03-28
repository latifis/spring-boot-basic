package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.res.ResRandomImageDto

interface DogService {

    fun getDogImage(): ResRandomImageDto

}