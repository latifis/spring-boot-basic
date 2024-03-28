package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.req.ReqProfileDto
import com.techno.springbootdasar.domain.dto.res.ResMessageDto
import com.techno.springbootdasar.domain.dto.res.ResProfileDto
import com.techno.springbootdasar.service.ProfileService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/v1/api/profile")
class ProfileController (
    val profileService: ProfileService
){
    @PostMapping()
    fun insert(
        @Valid
        @RequestParam seed: String,
        @RequestBody req: ReqProfileDto
    ): ResponseEntity<ResMessageDto<ResProfileDto>> {
        val response = profileService.insert(seed, req)
        return ResponseEntity.ok(response)
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response)
    }
    @PutMapping()
    fun update(
        @RequestParam uuid: UUID,
        @RequestBody req: ReqProfileDto
    ): ResponseEntity<ResMessageDto<ResProfileDto>> {
        val response = profileService.update(uuid, req)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/detail")
    fun detail(
        @RequestParam uuid: UUID
    ): ResponseEntity<ResMessageDto<ResProfileDto>> {
        val response = profileService.detail(uuid)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/list")
    fun list(): ResponseEntity<ResMessageDto<List<ResProfileDto>>> {
        val response = profileService.list()
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/delete")
    fun delete(@RequestParam uuid: UUID): ResponseEntity<ResMessageDto<String>> {
        val res = profileService.delete(uuid)
        return ResponseEntity.ok(res)
    }
}