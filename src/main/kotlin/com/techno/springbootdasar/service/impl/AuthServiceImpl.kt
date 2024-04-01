package com.techno.springbootdasar.service.impl

import com.techno.springbootdasar.domain.dto.req.ReqEncodeJWTDto
import com.techno.springbootdasar.domain.dto.req.ReqLoginDto
import com.techno.springbootdasar.domain.dto.req.ReqLoginJwtDto
import com.techno.springbootdasar.domain.dto.res.ResEncodeJWTDto
import com.techno.springbootdasar.domain.dto.res.ResLoginDto
import com.techno.springbootdasar.domain.dto.res.ResMessageDto
import com.techno.springbootdasar.exception.DataNotFoundException
import com.techno.springbootdasar.repository.ProfileRepository
import com.techno.springbootdasar.service.AuthService
import com.techno.springbootdasar.util.JWTGenerator
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl (
    val profileRepository: ProfileRepository
) : AuthService{

    //    override fun login(req: ReqLoginDto): ResponseEntity<ResMessageDto<ResLoginDto>> {
//        val username = profileRepository.findByUsername(req.username)
//
//        if (username != null){
//            if (username.password == req.password){
//
//                val token = JWTGenerator().login(req)
//                return ResponseEntity.ok(ResMessageDto(
//                    message = "Success Get Token JWT",
//                    data = ResLoginDto(username.id.toString(), token)
//                ))
//            } else {
//                throw IllegalArgumentException("Invalid Access")
//            }
//        } else {
//            throw IllegalArgumentException("Invalid Access")
//        }
//    }

    override fun login(req: ReqLoginDto): ResLoginDto {
        val token: String
        val id: String
        val userExist = profileRepository.findByUsername(req.username)
        if (userExist == null){
            throw DataNotFoundException("Username does not exist")
        }else{
            if(userExist.password != req.password){
                throw IllegalArgumentException("Invalid password")
            }
            val userData = ReqLoginJwtDto(
                id = userExist.id.toString(),
                name = userExist.name!!,
                email = userExist.email!!,
                username = userExist.username!!
            )
            id = userExist.id.toString()
            token = JWTGenerator().login(userData)
        }
        return ResLoginDto(id = id, token = token)
    }

}