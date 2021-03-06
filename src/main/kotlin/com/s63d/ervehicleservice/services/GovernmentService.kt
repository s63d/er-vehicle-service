package com.s63d.ervehicleservice.services

import com.s63d.ervehicleservice.domain.rest.GovernmentVehicle
import com.s63d.ervehicleservice.repositories.VehicleRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class GovernmentService(private val vehicleRepository: VehicleRepository, private val carTrackerService: CarTrackerService) {

    fun getCars(pageable: Pageable = Pageable.unpaged()) =  vehicleRepository.findAll(pageable).map {
        GovernmentVehicle(it.ownership)
    }

    fun assignCartracker(id: String): GovernmentVehicle {
        val vehicle = vehicleRepository.findById(id).orElseThrow { Exception("Car $id not found") }
        vehicle.carTracker = carTrackerService.createNew()

        return GovernmentVehicle(
                vehicleRepository.save(vehicle).ownership
        )
    }

    fun getCar(id: String) = GovernmentVehicle(
            vehicleRepository.findById(id).orElseGet { vehicleRepository.findByCarTrackerId(id) ?: throw Exception("$id not found") }
                    .ownership
    )
}