package com.s63d.ervehicleservice.services

import com.s63d.ervehicleservice.clients.PoliceClient
import com.s63d.ervehicleservice.domain.db.Lastseen
import com.s63d.ervehicleservice.domain.db.StolenCar
import com.s63d.ervehicleservice.repositories.LastseenRepository
import com.s63d.ervehicleservice.repositories.StolenVehicleRepository
import org.springframework.stereotype.Service

@Service
class PoliceService(private val vehicleService: VehicleService, private val stolenVehicleRepository: StolenVehicleRepository, private val lastseenRepository: LastseenRepository, private val policeClient: PoliceClient) {
//    val URL: String = "http://api.rekeningrijders.nl/police/v1/car/stolen"
    fun stolenCar(license: String) {
        var car = vehicleService.getByLicense(license)
        val lastseen = Lastseen(0, 0,2.34564, 3.46467)
        lastseenRepository.save(lastseen)
        val stolenCar = StolenCar(car.id, "AT", car.color, car.brand, car.type, "test", "test", "medium", 0, lastseen)
        stolenVehicleRepository.save(stolenCar)
        val result = policeClient.sendStolenCar(stolenCar)
        println(result)
    }

    fun createForeignStolenCar(stolenCar: StolenCar) {
        stolenVehicleRepository.save(stolenCar)
    }

    fun createStolenCar(stolenCar: StolenCar, lastseen: Lastseen){
        lastseenRepository.save(lastseen)
        stolenVehicleRepository.save(stolenCar)
    }
}