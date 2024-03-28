package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.req.ReqInsertDto
import com.techno.springbootdasar.domain.dto.req.ReqProfileDto
import com.techno.springbootdasar.domain.dto.res.ResGetMotorDto
import com.techno.springbootdasar.domain.dto.res.ResMessageDto
import com.techno.springbootdasar.domain.dto.res.ResProfileDto
import java.util.*

interface ProfileService{

    fun insert(seed: String, req: ReqProfileDto): ResMessageDto<ResProfileDto>

    fun update(uuid: UUID, req: ReqProfileDto): ResMessageDto<ResProfileDto>

    fun detail(uuid: UUID): ResMessageDto<ResProfileDto>

    fun list(): ResMessageDto<List<ResProfileDto>>

    fun delete(uuid: UUID): ResMessageDto<String>

}