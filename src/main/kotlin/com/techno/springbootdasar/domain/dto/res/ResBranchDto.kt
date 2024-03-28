package com.techno.springbootdasar.domain.dto.res

data class ResBranchDto(

    val OUT_STAT: String,

    val OUT_MESS: String,

    val OUT_DATA: List<ResBranchDataDto>
//    val OUT_DATA: Map<String, ResBranchDataDto>

)
