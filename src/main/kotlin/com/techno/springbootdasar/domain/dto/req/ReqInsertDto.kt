package com.techno.springbootdasar.domain.dto.req

import jakarta.persistence.Column
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty

data class ReqInsertDto(

    @field:NotBlank (message = "field notNullRequest cannot be blank")
    val nama:String,

    @field:NotEmpty (message = "field notEmptyRequest cannot be blank")
    val merk:String

)
