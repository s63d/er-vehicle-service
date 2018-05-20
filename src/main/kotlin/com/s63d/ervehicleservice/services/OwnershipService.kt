package com.s63d.ervehicleservice.services

import com.s63d.ervehicleservice.domain.Ownership
import com.s63d.ervehicleservice.domain.SimpleAccount
import com.s63d.ervehicleservice.domain.Vehicle
import com.s63d.ervehicleservice.repositories.OwnershipRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class OwnershipService(private val ownershipRepository: OwnershipRepository) {

    fun getAllForUser(account: SimpleAccount) = ownershipRepository.getByAccount(account)

    fun createNew(vehicle: Vehicle, account: SimpleAccount) : Ownership = ownershipRepository.save(Ownership(account = account, vehicle = vehicle))

    fun suspend(vehicle: Vehicle, account: SimpleAccount) : Ownership {
        val ownership = ownershipRepository.getLatestOwnership(vehicle.id, account.id) ?: throw Exception("No current ownership found for this vehicle") // TODO not found exception
        if(ownership.account != account)
            throw Exception("You are not authorized to change the ownership") // TODO Unauthorized exception

        ownership.endDate = Date()
        return ownershipRepository.save(ownership)
    }

    fun currentVehicles(accountId: Long) = ownershipRepository.getByAccountId(accountId).filter {
       it.endDate == null
    }

    fun pastVehicles(accountId: Long) = ownershipRepository.getByAccountId(accountId).filter {
        it.endDate != null
    }
}
