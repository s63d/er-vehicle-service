package com.s63d.ervehicleservice.controllers

import com.s63d.ervehicleservice.domain.db.StolenCar
import com.s63d.ervehicleservice.services.GovernmentService
import com.s63d.ervehicleservice.services.PoliceService
import org.springframework.data.domain.Pageable
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@PreAuthorize("hasRole('POLICE')")
@RestController
@RequestMapping("/api/police/vehicles")
class PoliceController(private val policeService: PoliceService) {

    @PostMapping("{license}/stolen")
    fun stolenCar(@PathVariable license: String) = policeService.stolenCar(license)

    @PostMapping("/stolen")
    fun createForeignStolenCar(stolenCar: StolenCar) = policeService.createForeignStolenCar(stolenCar)
}