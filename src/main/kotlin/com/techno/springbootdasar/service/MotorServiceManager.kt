package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.req.ReqInsertDto
import com.techno.springbootdasar.domain.dto.res.ResMessageDto

interface MotorServiceManager {

    fun saveMotor(req: ReqInsertDto): ResMessageDto<String>
}