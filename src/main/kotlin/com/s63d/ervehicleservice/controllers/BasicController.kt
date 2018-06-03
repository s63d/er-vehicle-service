package com.s63d.ervehicleservice.controllers

import com.s63d.ervehicleservice.domain.rest.BasicCar
import com.s63d.ervehicleservice.services.OwnershipService
import com.s63d.ervehicleservice.services.VehicleService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@PreAuthorize("hasRole('BASIC')")
@RequestMapping("/api/vehicles")
class BasicController(private val vehicleService: VehicleService, private val ownershipService: OwnershipService) {

    @GetMapping
    fun getCars(principal: Principal) = ownershipService.getAllForUser(principal.name).map {
        BasicCar(it)
    }

    @PostMapping
    fun createCar(@RequestParam license: String, @RequestParam type: String, @RequestParam brand: String,
                  @RequestParam weight: Int, @RequestParam color: String, principal: Principal) = vehicleService.createNew(license, type, brand, color, weight, principal.name.toLong()).let {
        BasicCar(it)
    }

    @PostMapping("{license}/suspend")
    fun suspendCar(@PathVariable license: String, principal: Principal) = vehicleService.suspend(license, principal.name.toLong()).let {
        BasicCar(it)
    }

}