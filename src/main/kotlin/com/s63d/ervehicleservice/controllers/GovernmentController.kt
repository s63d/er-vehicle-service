package com.s63d.ervehicleservice.controllers

import com.s63d.ervehicleservice.services.GovernmentService
import org.springframework.data.domain.Pageable
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@PreAuthorize("hasRole('GOVERNMENT')")
@RestController
@RequestMapping("/api/gov/vehicles")
class GovernmentController(private val governmentService: GovernmentService) {

    @GetMapping
    fun getCars(pageable: Pageable) = governmentService.getCars(pageable)

}