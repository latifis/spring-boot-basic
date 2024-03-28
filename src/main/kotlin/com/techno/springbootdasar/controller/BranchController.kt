package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.res.ResBranchDataDto
import com.techno.springbootdasar.service.BranchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/v1/api/branch-list")
class BranchController (
    val branchService: BranchService
){
    @GetMapping()
    fun getRandomDog(
        @RequestParam search: String,
        @RequestParam limit: String
    ): List<ResBranchDataDto>? {
        return branchService.getBranchList(search, limit)
    }
}