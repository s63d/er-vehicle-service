package com.s63d.ervehicleservice.domain.rest

import com.fasterxml.jackson.annotation.JsonIgnore
import com.s63d.ervehicleservice.domain.db.CarTracker
import com.s63d.ervehicleservice.domain.db.Ownership
import java.util.*

data class BasicVehicle(val id: String, val type: String, val brand: String, val color: String, val weight: Int,
                        val rate: Char, val registrationDate: Date, val endDate: Date?, @JsonIgnore private val carTracker: CarTracker?) {

    constructor(ownership: Ownership) : this(ownership.vehicle.id, ownership.vehicle.type, ownership.vehicle.brand, ownership.vehicle.color, ownership.vehicle.weight, ownership.vehicle.rate, ownership.startDate, ownership.endDate, ownership.vehicle.carTracker)

    val status: CarStatus
        get() {
            if (endDate != null)
                return CarStatus.SUSPENDED
            if (carTracker == null)
                return CarStatus.PENDING
            return CarStatus.APPROVED
        }

    enum class CarStatus {
        PENDING,
        APPROVED,
        SUSPENDED
    }

}
