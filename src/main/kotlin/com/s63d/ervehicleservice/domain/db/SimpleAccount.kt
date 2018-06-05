package com.s63d.ervehicleservice.domain.db

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "account")
data class SimpleAccount (@Id val id: Long = 0, @OneToMany(mappedBy = "account") @JsonIgnore val ownerships:List<Ownership> = emptyList())