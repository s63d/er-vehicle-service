package com.s63d.ervehicleservice.controllers

import com.s63d.ervehicleservice.domain.Vehicle
import com.s63d.ervehicleservice.services.OwnershipService
import com.s63d.ervehicleservice.services.VehicleService
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/api/vehicles")
class VehicleController(private val vehicleService: VehicleService, private val ownershipService: OwnershipService) {

    @GetMapping
    fun allVehicles(): Iterable<Vehicle> = vehicleService.vehicleRepository.findAll()

    @PostMapping
    fun createVehicle(@RequestParam license: String, @RequestParam type: String, @RequestParam brand: String,
                      @RequestParam weight: Int, @RequestParam color: String, principal: Principal
    ) = vehicleService.createNew(license, type, brand, color, weight, principal.name.toLong())


    @GetMapping("current")
    fun currentVehicles(@RequestParam user:Long?, principal: Principal) = ownershipService.currentVehicles(user ?: principal.name.toLong())

    @GetMapping("history")
    fun pastVehicles(@RequestParam user:Long?, principal: Principal) = ownershipService.pastVehicles(user ?: principal.name.toLong())

    @GetMapping("{license}")
    fun byLicense(@PathVariable license: String) = vehicleService.getByLicense(license)

    @PostMapping("{license}/suspend")
    fun suspendVehicle(@PathVariable license: String, principal: Principal) = vehicleService.suspend(license, principal.name.toLong())

}