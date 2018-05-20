package com.s63d.ervehicleservice.controllers

import com.s63d.ervehicleservice.services.JwtService
import com.s63d.ervehicleservice.services.OwnershipService
import com.s63d.ervehicleservice.services.VehicleService
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.*

/*
    TODO use spring-security for JWT parsing. Doing is manual is not ideal.
 */
@RestController
@RequestMapping("/api/vehicles")
class VehicleController(private val vehicleService: VehicleService, private val ownershipService: OwnershipService, private val jwtService: JwtService) {

    @GetMapping
    fun allVehicles(@RequestParam user:Long?, @RequestHeader(HttpHeaders.AUTHORIZATION) authHeader: String) = vehicleService.vehicleRepository.findAll() // vehicleService.getForAccount(user ?: jwtService.getAccountId(authHeader))

    @PostMapping
    fun createVehicle(@RequestParam license: String, @RequestParam type: String, @RequestParam brand: String,
                      @RequestParam weight: Int, @RequestParam color: String, @RequestHeader(HttpHeaders.AUTHORIZATION) authHeader: String) = vehicleService.createNew(license, type, brand, color, weight, jwtService.getAccountId(authHeader))


    @GetMapping("current")
    fun currentVehicles(@RequestParam user:Long?, @RequestHeader(HttpHeaders.AUTHORIZATION) authHeader: String) = ownershipService.currentVehicles(user ?: jwtService.getAccountId(authHeader))

    @GetMapping("history")
    fun pastVehicles(@RequestParam user:Long?, @RequestHeader(HttpHeaders.AUTHORIZATION) authHeader: String) = ownershipService.pastVehicles(user ?: jwtService.getAccountId(authHeader))

    @GetMapping("{license}")
    fun byLicense(@PathVariable license: String) = vehicleService.getByLicense(license)

    @PostMapping("{license}/suspend")
    fun suspendVehicle(@PathVariable license: String, @RequestHeader(HttpHeaders.AUTHORIZATION) authHeader: String) = vehicleService.suspend(license, jwtService.getAccountId(authHeader))

}