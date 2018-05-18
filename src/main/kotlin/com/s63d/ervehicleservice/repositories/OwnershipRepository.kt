package com.s63d.ervehicleservice.repositories

import com.s63d.ervehicleservice.domain.Ownership
import com.s63d.ervehicleservice.domain.SimpleAccount
import org.springframework.data.repository.CrudRepository

interface OwnershipRepository : CrudRepository<Ownership, Long> {
    fun getByAccount(account: SimpleAccount) : List<Ownership>
}