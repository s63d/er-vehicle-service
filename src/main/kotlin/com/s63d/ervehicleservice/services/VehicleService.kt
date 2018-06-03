package com.s63d.ervehicleservice.services

import com.s63d.ervehicleservice.domain.db.Ownership
import com.s63d.ervehicleservice.domain.db.Vehicle
import com.s63d.ervehicleservice.repositories.VehicleRepository
import com.s63d.ervehicleservice.utils.md5
import org.springframework.stereotype.Service

@Service
class VehicleService(internal val vehicleRepository: VehicleRepository, private val ownershipService: OwnershipService, private val accountService: AccountService) {

    fun createNew(license: String, type: String, brand: String, color: String, weight: Int, accountId: Long): Ownership {
        val account = accountService.getOrCreate(accountId)
        val vehicle = Vehicle(type, brand, color, weight, 'A', license.md5())

        if(vehicleRepository.existsById(vehicle.id))
            throw Exception("License already registered")

        vehicleRepository.save(vehicle)
        return ownershipService.createNew(vehicle, account)
    }

    fun getForAccount(accountId: Long) = accountService.findById(accountId).ownerships.map { it.vehicle }
    fun getByLicense(license: String) =
        vehicleRepository.findById(if(vehicleRepository.existsById(license))
            license
        else
            license.md5()).get()

    fun suspend(license: String, accountId: Long) = ownershipService.suspend(getByLicense(license), accountService.getOrCreate(accountId))
    fun getByCarTracker(carTrackerId: String) = vehicleRepository.findByCarTrackerId(carTrackerId)
}