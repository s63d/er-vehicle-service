package com.s63d.ervehicleservice.services

import com.s63d.ervehicleservice.domain.db.Ownership
import com.s63d.ervehicleservice.domain.db.SimpleAccount
import com.s63d.ervehicleservice.domain.db.Vehicle
import com.s63d.ervehicleservice.repositories.AccountRepository
import com.s63d.ervehicleservice.repositories.OwnershipRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class OwnershipService(private val ownershipRepository: OwnershipRepository, private val accountRepository: AccountRepository, private val accountService: AccountService) {

    fun getAllForUser(account: SimpleAccount) = ownershipRepository.getByAccount(account)

    fun getAllForUser(accountId: String): List<Ownership> {
        val account = accountService.getOrCreate(accountId.toLong())
        return getAllForUser(account)
    }
    fun createNewVehicle(vehicle: Vehicle, account: SimpleAccount) : Ownership = ownershipRepository.save(Ownership(account = account, vehicle = vehicle))

    fun suspend(vehicle: Vehicle, account: SimpleAccount) : Ownership {
        val ownership = ownershipRepository.getLatestOwnership(vehicle.id, account.id) ?: throw Exception("No current ownership found for this vehicle") // TODO not found exception
        if(ownership.account != account)
            throw Exception("You are not authorized to change the ownership") // TODO Unauthorized exception

        ownership.endDate = Date()
        return ownershipRepository.save(ownership)
    }

}
