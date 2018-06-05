package com.s63d.ervehicleservice.domain.db

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*


@Entity
data class Ownership(val startDate: Date = Date(), var endDate: Date? = null,
                     @JsonIgnore @ManyToOne val account: SimpleAccount,
                     @ManyToOne val vehicle: Vehicle, @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0)