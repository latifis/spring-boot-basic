package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.req.ReqLoginDto
import com.techno.springbootdasar.domain.dto.res.ResLoginDto
import com.techno.springbootdasar.domain.dto.res.ResMessageDto
import org.springframework.http.ResponseEntity

interface AuthService {

    fun login(req: ReqLoginDto): ResLoginDto

}