package com.elevenetc.tracker.backend.users

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsersService(
        @Autowired
        private val repository: UsersRepository
) {

    fun delete(id: String) {
        repository.deleteById(id.toLong())
    }

    fun save(user: User) {
        repository.save(user)
    }

    fun getAll(): List<User> {
        return repository.findAll().toList()
    }
}