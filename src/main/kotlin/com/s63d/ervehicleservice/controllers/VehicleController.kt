package com.s63d.ervehicleservice.controllers

import com.s63d.ervehicleservice.services.VehicleService
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.*

@RestController("/api/vehicle")
class VehicleController(private val vehicleService: VehicleService) {

    @PostMapping
    fun createVehicle(@RequestParam license: String, @RequestParam type: String, @RequestParam brand: String,
                      @RequestParam weight: Int, @RequestParam color: String, @RequestHeader(HttpHeaders.AUTHORIZATION) accountId: Long) = vehicleService.createNew(license, type, brand, color, weight, accountId)

    @GetMapping
    fun allVehicles() = vehicleService.getForAccount(1) // TODO get account id from header

    @GetMapping("{license}")
    fun byLicense(@PathVariable license: String) = vehicleService.getByLicense(license)

}