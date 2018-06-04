package com.s63d.ervehicleservice.repositories

import com.s63d.ervehicleservice.domain.db.Lastseen
import com.s63d.ervehicleservice.domain.db.StolenCar
import com.s63d.ervehicleservice.domain.db.Vehicle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface StolenVehicleRepository : JpaRepository<StolenCar, String> {
}
