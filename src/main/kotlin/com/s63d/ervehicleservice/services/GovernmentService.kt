package com.s63d.ervehicleservice.services

import com.s63d.ervehicleservice.domain.rest.GovernmentVehicle
import com.s63d.ervehicleservice.repositories.VehicleRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class GovernmentService(private val vehicleRepository: VehicleRepository) {

    fun getCars(pageable: Pageable = Pageable.unpaged()) =  vehicleRepository.findAll(pageable).map {
        GovernmentVehicle(it.ownership)
    }
}