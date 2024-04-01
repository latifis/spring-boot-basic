package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.req.ReqEncodeJWTDto
import com.techno.springbootdasar.domain.dto.res.ResEncodeJWTDto
import com.techno.springbootdasar.domain.dto.res.ResMessageDto
import com.techno.springbootdasar.util.JWTGenerator
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api")
class JWTController {

    @PostMapping("/encode")
    fun encodeJWT(@RequestBody request: ReqEncodeJWTDto): ResponseEntity<ResMessageDto<ResEncodeJWTDto>>{
        val token = JWTGenerator().createJWT(request)
        return ResponseEntity.ok(ResMessageDto(
            message = "Success Get Token JWT",
            data = ResEncodeJWTDto(request.id, token)
        ))
    }
}