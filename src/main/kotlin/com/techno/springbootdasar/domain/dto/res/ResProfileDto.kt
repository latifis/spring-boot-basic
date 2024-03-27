package com.techno.springbootdasar.domain.dto.res

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull
import java.util.UUID

data class ResProfileDto(

    val id: UUID?,

    val name: String?,

    val username: String?,

    val email: String?

)
