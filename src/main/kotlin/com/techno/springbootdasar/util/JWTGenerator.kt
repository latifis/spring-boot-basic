package com.techno.springbootdasar.util

import com.techno.springbootdasar.domain.dto.req.ReqEncodeJWTDto
import com.techno.springbootdasar.domain.dto.req.ReqEncodeProfileDto
import com.techno.springbootdasar.domain.dto.req.ReqLoginDto
import com.techno.springbootdasar.domain.dto.req.ReqLoginJwtDto
import com.techno.springbootdasar.exception.DataNotFoundException
import com.techno.springbootdasar.exception.InvalidToken
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwt
import io.jsonwebtoken.JwtBuilder
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.*
import javax.crypto.spec.SecretKeySpec

class JWTGenerator {
    companion object {
        private const val SECRET_KEY = "YOUR_SUPER_SECRET_KEY_THAT_IS_AT_LEAST_256_BITS_LONG"
        private val instance: JWTGenerator = JWTGenerator()
    }

    fun createJWT(req: ReqEncodeJWTDto): String {
        val signatureAlgorithm: SignatureAlgorithm = SignatureAlgorithm.HS256
        val nowMills: Long = System.currentTimeMillis()
        val now = Date(nowMills)

        val apiKeySecretBytes = SECRET_KEY.toByteArray()
        val signingKey = SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.jcaName)

        val builder: JwtBuilder = Jwts.builder().setSubject(req.id)
            .setIssuedAt(now)
            .claim("id", req.id)
            .claim("role", req.role)
            .claim("email", req.email)
            .claim("password", req.password)
            .setIssuer("technocenter")
            .setAudience("technocenter")
            .signWith(signingKey, signatureAlgorithm)

        val expMills = nowMills + 3600000L
        val exp = Date(expMills)
        builder.setExpiration(exp)

        return builder.compact()
    }

    fun decodeJWT(jwt: String): Claims{
        try {
            val claims: Claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.toByteArray())
                .build()
                .parseClaimsJws(jwt).body
            return claims
        } catch (e: JwtException){
            e.printStackTrace()
            throw InvalidToken("Invalid Token")
        }
    }

    fun login(req: ReqLoginJwtDto): String{
        val signatureAlgorithm: SignatureAlgorithm = SignatureAlgorithm.HS256
        val nowMillis: Long = System.currentTimeMillis()
        val now = Date(nowMillis)

        val apiKeySecretBytes = SECRET_KEY.toByteArray()
        val signInKey = SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.jcaName)

        val builder: JwtBuilder = Jwts.builder().setSubject(req.id.toString())
            .claim("id", req.id)
            .claim("name", req.name)
            .claim("username", req.username)
            .claim("email", req.email)
            .setIssuer("technocenter")
            .setAudience("technocenter")
            .signWith(signInKey, signatureAlgorithm)

        val expMillis = nowMillis + 3600000L
        val exp = Date(expMillis)
        builder.setExpiration(exp)

        return builder.compact()
    }
}