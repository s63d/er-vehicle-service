package com.s63d.ervehicleservice.services

import com.s63d.ervehicleservice.domain.CarTracker
import com.s63d.ervehicleservice.repositories.CarTrackerRepository
import org.springframework.stereotype.Service

@Service
class CarTrackerService(private val carTrackerRepository: CarTrackerRepository, private val vehicleService: VehicleService) {

    fun createNew() = carTrackerRepository.save(CarTracker())

    fun getById(id: String) = carTrackerRepository.findById(id).orElseThrow { Exception("Car tracker $id not found.") } // TODO: Not found exception

    fun getAll() = carTrackerRepository.findAll()

    fun assignTracker(carId: String, trackerId: String) {
        val vehicle = vehicleService.getByLicense(carId)
        val tracker = getById(trackerId)
        vehicle.carTracker = tracker
        vehicleService.vehicleRepository.save(vehicle)
    }
}