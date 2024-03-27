package com.techno.springbootdasar.domain.dto.req

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull

data class ReqProfileDto(

    @field:NotNull
    @field:NotBlank(message = "Nama tidak boleh kosong")
    @field:Pattern(regexp = "^[a-zA-Z]*\$", message = "Hanya huruf yang diperbolehkan")
    @field:Size(max = 100, message = "Nama tidak boleh lebih dari 100 karakter")
    val nama: String,

    @field:NotEmpty(message = "Username tidak boleh kosong")
    @field:Size(max = 32, message = "Username tidak boleh lebih dari 32 karakter")
    val username: String,

    @field:NotNull
    @field:NotBlank(message = "Nama tidak boleh kosong")
    @field:Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$", message = "Alamat email tidak valid")
    val email: String,

    @field:NotNull
    @field:Size(max = 32, message = "Password tidak boleh lebih dari 32 karakter")
    val password: String

)
