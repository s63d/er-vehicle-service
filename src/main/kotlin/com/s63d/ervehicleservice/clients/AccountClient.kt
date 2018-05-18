package com.s63d.ervehicleservice.clients

import com.s63d.ervehicleservice.domain.SimpleAccount
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient("accounts", url = "\${urls.account-service}/api")
interface AccountClient {

    @GetMapping("/users/{id}")
    fun getById(@PathVariable id:Long) : SimpleAccount

}