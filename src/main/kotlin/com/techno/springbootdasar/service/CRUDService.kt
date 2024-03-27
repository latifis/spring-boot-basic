package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.req.ReqInsertDto
import com.techno.springbootdasar.domain.dto.res.ResMessageDto
import java.util.UUID

interface CRUDService {
    fun insert(req: ReqInsertDto): ResMessageDto<String>

    fun update(uuid:UUID, req:ReqInsertDto): ResMessageDto<String>
}