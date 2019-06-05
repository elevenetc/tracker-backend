package com.elevenetc.tracker.backend.users

import org.springframework.data.repository.CrudRepository

interface UsersRepository : CrudRepository<User, Long> {
    fun existsByEmail(email: String): Boolean
    fun getByEmail(email: String): User
}