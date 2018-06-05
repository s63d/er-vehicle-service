package com.s63d.ervehicleservice.clients

import com.s63d.ervehicleservice.domain.db.SimpleAccount
import com.s63d.ervehicleservice.domain.db.StolenCar
import feign.Headers
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@FeignClient("police", url = "http://api.rekeningrijders.nl/police/v1/car/stolen")
interface PoliceClient {

    @PostMapping
    fun sendStolenCar(stolenCar: StolenCar)

}