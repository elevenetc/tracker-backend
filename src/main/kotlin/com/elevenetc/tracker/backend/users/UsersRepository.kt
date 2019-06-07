package com.elevenetc.tracker.backend.users

import org.springframework.data.repository.CrudRepository
import java.util.*

interface UsersRepository : CrudRepository<User, UUID> {
    fun existsByEmail(email: String): Boolean
    fun getByEmail(email: String): User
}