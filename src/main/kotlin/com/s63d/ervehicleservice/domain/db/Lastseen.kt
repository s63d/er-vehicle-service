package com.s63d.ervehicleservice.domain.db

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Lastseen(@Id @Transient @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null, val timestamp: Long, val lat: Double, val lng: Double)