package com.elevenetc.tracker.backend.users.rest

import com.elevenetc.tracker.backend.users.User
import com.elevenetc.tracker.backend.users.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UsersRestController {

    @Autowired
    lateinit var service: UsersService

    @PostMapping("/user")
    fun post(@RequestBody u: CreateUser) {
        val user = User().apply {
            email = u.email
            name = u.name
        }
        service.save(user)
    }

    @GetMapping("/user")
    fun get(): List<UserDto> {
        return service.getAll().map {
            UserDto(it.id.toString(), it.email)
        }
    }

    @DeleteMapping("/user")
    fun delete(@RequestBody user: DeleteUser) {
        service.delete(user.id)
    }
}