package com.s63d.ervehicleservice.domain.rest

import com.s63d.ervehicleservice.domain.db.Vehicle

// TODO correct model for JSON
data class GovernmentCar(val id: String) {
    constructor(vehicle: Vehicle) : this(vehicle.id)
}