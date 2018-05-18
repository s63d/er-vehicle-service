package com.s63d.ervehicleservice.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
data class Vehicle(val type: String, val brand: String, val color: String, val weight: Int,
                   val rate: Char, @Id val id: String = "", @OneToOne var carTracker: CarTracker? = null)