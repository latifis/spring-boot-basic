package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.req.ReqInsertDto
import com.techno.springbootdasar.domain.dto.req.ReqPerhitunganDto
import com.techno.springbootdasar.domain.dto.res.ResGetMotorDto
import com.techno.springbootdasar.domain.dto.res.ResHasilDto
import com.techno.springbootdasar.domain.dto.res.ResMessageDto
import com.techno.springbootdasar.service.CRUDService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/v1/api/crud")
class CRUDController (
    val crudService: CRUDService
){
    @PostMapping()
    fun insert(@RequestBody req: ReqInsertDto): ResponseEntity<ResMessageDto<String>> {
        val response = crudService.insert(req)
        return ResponseEntity.ok(response)
    }
    @PutMapping()
    fun update(
        @RequestParam uuid: UUID,
        @RequestBody req: ReqInsertDto
    ): ResponseEntity<ResMessageDto<String>> {
        val response = crudService.update(uuid, req)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/detail")
    fun detail(
        @RequestParam uuid: UUID
    ): ResponseEntity<ResMessageDto<ResGetMotorDto>> {
        val response = crudService.detail(uuid)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/list")
    fun list(): ResponseEntity<ResMessageDto<List<ResGetMotorDto>>> {
        val response = crudService.list()
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/delete")
    fun delete(@RequestParam uuid: UUID): ResponseEntity<ResMessageDto<String>>{
        val res = crudService.delete(uuid)
        return ResponseEntity.ok(res)
    }

}