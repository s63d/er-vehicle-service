package com.s63d.ervehicleservice.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class SimpleAccount (@Id val id: Long = 0, @OneToMany(mappedBy = "account") @JsonIgnore val ownerships:List<Ownership> = emptyList())