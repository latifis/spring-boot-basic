package com.techno.springbootdasar.domain.dto.res

import com.fasterxml.jackson.annotation.JsonProperty

data class ResBiodataDto(

    @JsonProperty("firstName")
    val firstName: String,

    @JsonProperty("lastName")
    val lastName: String
)
