package com.s63d.ervehicleservice.services

import com.auth0.jwt.JWT
import com.auth0.jwt.interfaces.Claim
import org.springframework.stereotype.Service

@Service
class JwtService {

    fun decode(rawToken: String): MutableMap<String, Claim> {
        val token = rawToken.replace("Bearer ", "")
        return JWT.decode(token).claims
    }

}