package com.s63d.ervehicleservice.controllers

import io.jsonwebtoken.Jwts
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/vehicle")
class VehicleController {

    @PostMapping
    fun createVehicle(@RequestParam license: String, @RequestParam type: String, @RequestParam brand: String,
                      @RequestParam weight: Int, @RequestHeader(HttpHeaders.AUTHORIZATION) authHeader: String) {
        val uid = parseUid(authHeader)
        println(uid)
    }



    private fun parseUid(rawHeader: String) : Long {
        val header = rawHeader.replace("Bearer ", "")
        return Jwts.parser().setSigningKey("c2VjcmV0").parseClaimsJws(rawHeader).body["userId"] as Long
    }
}