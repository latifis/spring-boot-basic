package com.techno.springbootdasar.rest

import com.techno.springbootdasar.domain.dto.res.ResBranchDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(value = "BranchApi", url = "https://apidev.acc.co.id")
interface BranchApiClient {

    @PostMapping("/restv2/accgrape/getdata/getbranch")
    fun getBranchList(
        @RequestHeader("APIKey") apiKey: String = "1234567890",
        @RequestHeader("X-Content-Type-Options") xContentTypeOptions: String = "nosniff",
        @RequestHeader("X-XSS-Protection") xXSSProtection: String = "1; mode=block",
        @RequestHeader("Strict-Transport-Security") strictTransportSecurity: String = "max-age=31536000; includeSubDomains; preload",
        @RequestHeader("X-Frame-Options") xFrameOptions: String = "SAMEORIGIN",
//        @RequestHeader("Content-Type") contentType: String = "application/json",
        @RequestBody req: Map<String, Map<String, String>>
    ): ResBranchDto

}