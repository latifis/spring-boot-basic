package com.techno.springbootdasar.rest

import com.techno.springbootdasar.domain.dto.res.ResAvatarDto
import com.techno.springbootdasar.domain.dto.res.ResRandomImageDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(value = "AvatarApi", url = "https://api.dicebear.com")
interface AvatarApiClient {

    @GetMapping(
        "/8.x/pixel-art/svg",
        produces = ["image/svg+xml"]
    )
    fun getAvatar(
        @RequestParam seed: String?
    ): ResponseEntity<String>

}