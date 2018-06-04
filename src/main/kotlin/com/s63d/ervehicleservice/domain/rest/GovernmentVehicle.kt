package com.s63d.ervehicleservice.domain.rest

import com.s63d.ervehicleservice.domain.db.Ownership
import java.util.*

data class GovernmentVehicle(val id: String, val type: String, val brand: String, val color: String, val weight: Int,
                             val rate: Char, val registrationDate: Date, val endDate: Date?, private val carTrackerId: String?, val stolen: Boolean = false) {
    constructor(ownership: Ownership) : this(ownership.vehicle.id, ownership.vehicle.type, ownership.vehicle.brand, ownership.vehicle.color, ownership.vehicle.weight, ownership.vehicle.rate, ownership.startDate, ownership.endDate, ownership.vehicle.carTracker?.id)
}