package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.req.ReqEncodeJWTDto
import com.techno.springbootdasar.domain.dto.req.ReqLoginDto
import com.techno.springbootdasar.domain.dto.res.ResEncodeJWTDto
import com.techno.springbootdasar.domain.dto.res.ResLoginDto
import com.techno.springbootdasar.domain.dto.res.ResLoginJwtDto
import com.techno.springbootdasar.domain.dto.res.ResMessageDto
import com.techno.springbootdasar.service.AuthService
import com.techno.springbootdasar.util.JWTGenerator
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/api/auth")
class AuthController (
    val authService: AuthService
){

    @PostMapping("/login")
    fun login(@RequestBody req: ReqLoginDto): ResponseEntity<ResMessageDto<ResLoginDto>>{
        val res = authService.login(req)
        return ResponseEntity.ok(ResMessageDto(
            message = "Success Login",
            data = res
        ))
    }

    @GetMapping("/validate")
    fun validate(@RequestHeader token: String): ResponseEntity<ResMessageDto<ResLoginJwtDto>>{
        val claim = JWTGenerator().decodeJWT(token)
        return ResponseEntity.ok(ResMessageDto(
            message = "Success Decode Jwt",
            data = ResLoginJwtDto(
                claim["id"].toString(),
                claim["name"].toString(),
                claim["username"].toString(),
                claim["email"].toString()
            )
        ))
    }

}