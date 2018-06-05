package com.s63d.ervehicleservice.repositories

import com.s63d.ervehicleservice.domain.db.Ownership
import com.s63d.ervehicleservice.domain.db.SimpleAccount
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface OwnershipRepository : CrudRepository<Ownership, Long> {

    fun getByAccount(account: SimpleAccount) : List<Ownership>

    fun getByAccountId(accountId: Long) : List<Ownership>

    @Query("SELECT o FROM Ownership o WHERE o.vehicle.id = ?1 AND o.account.id = ?2 AND o.endDate IS NULL")
    fun getLatestOwnership(vehicleId: String, ownerId: Long) : Ownership?
}