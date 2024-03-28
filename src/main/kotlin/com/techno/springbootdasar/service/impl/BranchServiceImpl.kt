package com.techno.springbootdasar.service.impl

import com.techno.springbootdasar.domain.dto.res.ResBranchDataDto
import com.techno.springbootdasar.domain.dto.res.ResBranchDto
import com.techno.springbootdasar.rest.BranchApiClient
import com.techno.springbootdasar.service.BranchService
import org.springframework.stereotype.Service

@Service
class BranchServiceImpl (
    private val branchApiClient: BranchApiClient
): BranchService{
    override fun getBranchList(search: String, limit: String): List<ResBranchDataDto> {
        val reqArea = mapOf("P_SEARCH" to search, "P_LIMIT" to limit)
        val requestBranch : Map<String, Map<String, String>> = mapOf("doGetBranch" to reqArea)
        val branches = branchApiClient.getBranchList(req = requestBranch).OUT_DATA
        return branches
    }


}