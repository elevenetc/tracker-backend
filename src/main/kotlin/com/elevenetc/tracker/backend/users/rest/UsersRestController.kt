package com.elevenetc.tracker.backend.users.rest

import com.elevenetc.tracker.backend.users.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class UsersRestController {

    @Autowired
    lateinit var service: UsersService

    @PostMapping("/user")
    fun post(@RequestBody u: CreateUser): UUID {
        return service.createNewUser(u.email, u.password, u.name)
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