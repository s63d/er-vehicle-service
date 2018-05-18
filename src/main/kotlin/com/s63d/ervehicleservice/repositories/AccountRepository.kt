package com.s63d.ervehicleservice.repositories

import com.s63d.ervehicleservice.domain.SimpleAccount
import org.springframework.data.repository.CrudRepository

interface AccountRepository : CrudRepository<SimpleAccount, Long>