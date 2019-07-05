package com.elevenetc.tracker.backend.users.rest

import com.elevenetc.tracker.backend.authentication.AuthenticationService
import com.elevenetc.tracker.backend.devices.rest.DeviceDto
import com.elevenetc.tracker.backend.motorcycles.rest.MotoDto
import com.elevenetc.tracker.backend.users.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class UsersRestController {

    @Autowired
    lateinit var service: UsersService

    @Autowired
    lateinit var authenticationService: AuthenticationService

    @PostMapping("/users")
    fun register(@RequestBody u: RegisterUser): UserDto {
        val result = service.register(u.email, u.password)
        return UserDto(result.first.value, result.second.id!!)
    }

    @PostMapping("/users/login")
    fun login(@RequestBody body: LoginDto): UserDto {
        val result = service.login(body.email, body.password)
        val token = result.first.value
        val user = result.second
        return UserDto(token, user.id!!, user.motorcycles.map { MotoDto(it) }, user.devices.map { DeviceDto(it) })
    }

    @PostMapping("/users/{user-id}/logout")
    fun logout(
            @RequestHeader("access-token") token: UUID,
            @PathVariable("user-id") userId: UUID) {
        authenticationService.verify(token, userId)
        service.logout(userId, token)
    }

    @GetMapping("/users/{id}")
    fun get(@PathVariable("id") userId: UUID,
            @RequestHeader("access-token") token: UUID): UserDto {
        authenticationService.verify(token, userId)
        val user = service.getUser(userId)
        return UserDto(
                token,
                user.id!!,
                user.motorcycles.map { m -> MotoDto(m) },
                user.devices.map { d -> DeviceDto(d) }
        )
    }
}