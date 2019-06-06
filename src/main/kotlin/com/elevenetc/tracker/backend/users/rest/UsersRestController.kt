package com.elevenetc.tracker.backend.users.rest

import com.elevenetc.tracker.backend.users.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersRestController {

    @Autowired
    lateinit var service: UsersService

    @PostMapping("/user")
    fun register(@RequestBody u: RegisterUser): UserDto {
        return UserDto(service.createNewUser(u.email, u.password, u.name))
    }

    @PostMapping("/user/login")
    fun login(@RequestBody u: Login): UserDto {
        return UserDto(service.login(u.email, u.password))
    }

    @PostMapping("/user/logout")
    fun logout(@RequestBody u: Logout) {
        service.logout(u.email, u.token)
    }
}