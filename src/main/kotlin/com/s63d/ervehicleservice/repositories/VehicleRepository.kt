package com.s63d.ervehicleservice.repositories

import com.s63d.ervehicleservice.domain.Vehicle
import org.springframework.data.repository.CrudRepository

interface VehicleRepository : CrudRepository<Vehicle, String>