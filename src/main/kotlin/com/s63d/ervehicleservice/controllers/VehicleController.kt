package com.s63d.ervehicleservice.controllers

import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/vehicle")
class VehicleController {

    @PostMapping
    fun createVehicle(@RequestParam license: String, @RequestParam type: String, @RequestParam brand: String,
                      @RequestParam weight: Int, @RequestHeader(HttpHeaders.AUTHORIZATION) authHeader: String) {

        println(authHeader)
    }
}