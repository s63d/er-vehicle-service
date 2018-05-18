package com.s63d.ervehicleservice.services

import com.s63d.ervehicleservice.domain.Ownership
import com.s63d.ervehicleservice.domain.SimpleAccount
import com.s63d.ervehicleservice.domain.Vehicle
import com.s63d.ervehicleservice.repositories.OwnershipRepository
import org.springframework.stereotype.Service

@Service
class OwnershipService(private val ownershipRepository: OwnershipRepository) {

    fun getAllForUser(account: SimpleAccount) = ownershipRepository.getByAccount(account)

    fun createNew(vehicle: Vehicle, account: SimpleAccount) : Ownership = ownershipRepository.save(Ownership(account = account, vehicle = vehicle))
}