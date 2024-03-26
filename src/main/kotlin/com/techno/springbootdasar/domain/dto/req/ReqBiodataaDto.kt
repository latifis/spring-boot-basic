package com.techno.springbootdasar.domain.dto.req

import com.fasterxml.jackson.annotation.JsonProperty

data class ReqBiodataaDto(
    @JsonProperty("firstName")
    val firstName: String,

    @JsonProperty("lastName")
    val lastName: String
)
