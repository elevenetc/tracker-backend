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

    @PostMapping("/user")
    fun register(@RequestBody u: RegisterUser): UserDto {
        return UserDto(service.createNewUser(
                u.email,
                u.password
        ))
    }

    @PostMapping("/user/login")
    fun login(@RequestBody b: Login): UserDto {
        return UserDto(service.login(b.email, b.password, b.device.hardwareId, b.device.name, b.device.manufacturer))
    }

    @PostMapping("/user/logout")
    fun logout(@RequestBody u: Logout, @RequestHeader("Token") token:UUID) {
        authenticationService.verify(token)
        service.logout(u.email, u.token)
    }

    @GetMapping("/user")
    fun info(@RequestHeader("Token") token: UUID): UserDto {
        val id = authenticationService.verifyAndGetId(token)
        val user = service.getUser(id)
        return UserDto(
                token,
                user.motorcycles.map { m -> MotoDto(m) },
                user.devices.map { d -> DeviceDto(d) }
        )
    }
}