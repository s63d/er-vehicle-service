package com.s63d.ervehicleservice.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class CarTracker(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long)