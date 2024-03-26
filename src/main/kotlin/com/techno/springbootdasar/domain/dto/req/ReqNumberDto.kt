package com.techno.springbootdasar.domain.dto.req

import com.fasterxml.jackson.annotation.JsonProperty

data class ReqNumberDto(

    @JsonProperty("number")
    val number: Int
)
