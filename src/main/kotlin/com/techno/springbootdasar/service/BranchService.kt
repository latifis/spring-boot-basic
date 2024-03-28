package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.res.ResBranchDataDto

interface BranchService {

    fun getBranchList(search: String, limit: String): List<ResBranchDataDto>

}