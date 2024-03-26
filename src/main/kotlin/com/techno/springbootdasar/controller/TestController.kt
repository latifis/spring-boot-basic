package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.req.ReqBiodataaDto
import com.techno.springbootdasar.domain.dto.req.ReqNumberDto
import com.techno.springbootdasar.domain.dto.res.ResBiodataDto
import com.techno.springbootdasar.service.LogicService
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api")
class TestController (
    @Value("\${name.firstName}") private val firstName: String,
    @Value("\${name.lastName}") private val lastName: String,
    private val logicService: LogicService
){

    @GetMapping("/test")
    fun testGetMapping(): ResponseEntity<LinkedHashMap<String, String>>{
        val response : LinkedHashMap<String, String> = LinkedHashMap()
        response["first_name"] = firstName
        response["last_name"] = lastName

        return ResponseEntity.ok().body(response)
    }

    @GetMapping("/user")
    fun getName(@RequestParam("age") age: String): ResponseEntity<Any>{
        val response : LinkedHashMap<String, String> = LinkedHashMap()
        response["firstName"] = firstName
        response["lastName"] = lastName
        response["age"] = age

        return ResponseEntity.ok().body(response)
    }

    @PostMapping("/oddsOrEvent")
    fun getoddsOrEvent(@RequestBody request:ReqNumberDto) : ResponseEntity<Any>{
        val response = LinkedHashMap<String, String>()
        response["result"] = logicService.oddsOrEvent(request.number)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/api")
    fun getApi(): ResponseEntity<ResBiodataDto>{
        val response = ResBiodataDto(
            firstName = "Latief",
            lastName = "irfan"
        )

        return ResponseEntity.ok(response)
    }

    @PostMapping("/api")
    fun create(@RequestBody request: ReqBiodataaDto): ResponseEntity<ResBiodataDto>{
        val response = ResBiodataDto(
            firstName = request.firstName,
            lastName = request.lastName
        )

        return ResponseEntity.ok(response)
    }
}