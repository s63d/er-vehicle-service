package com.s63d.ervehicleservice.controllers

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/trackers")
class CarTrackerController {

    @PostMapping
    fun createTracker(@RequestParam trackerId: Long) {

    }

    @GetMapping
    fun getAll() {

    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: Long) {

    }

    @PutMapping
    fun updateTracker(@RequestParam carId: String, @RequestParam trackerId: Long) {

    }

}