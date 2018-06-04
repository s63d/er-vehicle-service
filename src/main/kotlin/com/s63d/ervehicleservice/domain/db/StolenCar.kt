package com.s63d.ervehicleservice.domain.db

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
data class StolenCar(@Id val license: String = "", val country: String?, val color: String, val brand: String, val type: String, val description: String, val comment: String,
                     val severity: String, val timestamp: Long, @OneToOne val lastseen: Lastseen)