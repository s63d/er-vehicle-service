package com.s63d.ervehicleservice.controllers

import com.s63d.ervehicleservice.services.OwnershipService
import com.s63d.ervehicleservice.services.VehicleService
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/vehicles")
class VehicleController(private val vehicleService: VehicleService, private val ownershipService: OwnershipService) {

    @GetMapping
    fun allVehicles(@RequestParam user:Long?, @RequestHeader(HttpHeaders.AUTHORIZATION) accountId: Long) = vehicleService.getForAccount(user ?: accountId) // TODO get account id from header

    @PostMapping
    fun createVehicle(@RequestParam license: String, @RequestParam type: String, @RequestParam brand: String,
                      @RequestParam weight: Int, @RequestParam color: String, @RequestHeader(HttpHeaders.AUTHORIZATION) accountId: Long) = vehicleService.createNew(license, type, brand, color, weight, accountId)


    @GetMapping("current")
    fun currentVehicles(@RequestParam user:Long?, @RequestHeader(HttpHeaders.AUTHORIZATION) accountId: Long) = ownershipService.currentVehicles(user ?: accountId)

    @GetMapping("{license}")
    fun byLicense(@PathVariable license: String) = vehicleService.getByLicense(license)

    @PostMapping("{license}/suspend")
    fun suspendVehicle(@PathVariable license: String, @RequestHeader(HttpHeaders.AUTHORIZATION) accountId: Long) = vehicleService.suspend(license, accountId)

}