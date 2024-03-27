package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.req.ReqInsertDto
import com.techno.springbootdasar.domain.dto.res.ResGetMotorDto
import com.techno.springbootdasar.domain.dto.res.ResMessageDto
import java.util.*

interface ProfileService {

    fun insert(req: ReqInsertDto): ResMessageDto<String>

    fun update(uuid: UUID, req: ReqInsertDto): ResMessageDto<String>

    fun detail(uuid: UUID): ResMessageDto<ResGetMotorDto>

    fun list(): ResMessageDto<List<ResGetMotorDto>>

    fun delete(uuid: UUID): ResMessageDto<String>

}