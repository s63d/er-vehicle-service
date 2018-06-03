package com.s63d.ervehicleservice.repositories

import com.s63d.ervehicleservice.domain.db.Vehicle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface VehicleRepository : JpaRepository<Vehicle, String> {
    fun findByCarTrackerId(carTrackerId: String): Vehicle
}