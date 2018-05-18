package com.s63d.ervehicleservice.domain

import java.util.*
import javax.persistence.*


@Entity
data class Ownership(val startDate: Date = Date(), val endDate: Date? = null,
                     @ManyToOne val account: SimpleAccount,
                     @ManyToOne val vehicle: Vehicle, @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0)