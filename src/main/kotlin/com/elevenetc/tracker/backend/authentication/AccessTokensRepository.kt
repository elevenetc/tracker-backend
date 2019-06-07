package com.elevenetc.tracker.backend.authentication

import org.springframework.data.repository.CrudRepository
import java.util.*

interface AccessTokensRepository : CrudRepository<AccessToken, UUID> {
    fun getByValue(value: UUID): AccessToken
    fun existsByValue(value: UUID): Boolean
}