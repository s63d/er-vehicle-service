package com.s63d.ervehicleservice.controllers

import com.s63d.ervehicleservice.services.GovernmentService
import org.springframework.data.domain.Pageable
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@PreAuthorize("hasRole('GOVERNMENT')")
@RestController
@RequestMapping("/api/gov/vehicles")
class GovernmentController(private val governmentService: GovernmentService) {

    @GetMapping
    fun getCars(pageable: Pageable) = governmentService.getCars(pageable)

    @PostMapping("{id}/assignCartracker")
    fun assignCartracker(@PathVariable id: String) = governmentService.assignCartracker(id)

    @GetMapping("{id}")
    fun getCar(@PathVariable id: String) = governmentService.getCar(id)
}