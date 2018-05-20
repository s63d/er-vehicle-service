package com.s63d.ervehicleservice.controllers

import com.s63d.ervehicleservice.services.CarTrackerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/trackers")
class CarTrackerController(private val carTrackerService: CarTrackerService) {

    @PostMapping
    fun createTracker() = carTrackerService.createNew()

    @GetMapping
    fun getAll() = carTrackerService.getAll().map { it.id }

    @GetMapping("{id}")
    fun getById(@PathVariable id: String) = carTrackerService.getById(id)

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun assignTracker(@RequestParam carId: String, @RequestParam trackerId: String) = carTrackerService.assignTracker(carId, trackerId)

}