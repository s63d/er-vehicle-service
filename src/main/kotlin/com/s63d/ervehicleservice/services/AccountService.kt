package com.s63d.ervehicleservice.services

import com.s63d.ervehicleservice.domain.db.SimpleAccount
import com.s63d.ervehicleservice.repositories.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService(private val accountRepository: AccountRepository) {

    fun getOrCreate(accountId: Long) : SimpleAccount {
        val dbAccount = accountRepository.findById(accountId)
        if(dbAccount.isPresent)
            return dbAccount.get()

        val account = SimpleAccount(accountId)
        return accountRepository.save(account)
    }

    fun findById(accountId: Long) = accountRepository.findById(accountId).get()
}