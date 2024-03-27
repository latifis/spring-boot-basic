package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.req.ReqInsertDto
import com.techno.springbootdasar.domain.dto.req.ReqPerhitunganDto
import com.techno.springbootdasar.domain.dto.res.ResHasilDto
import com.techno.springbootdasar.domain.dto.res.ResMessageDto
import com.techno.springbootdasar.service.CRUDService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
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

}