package com.elevenetc.tracker.backend.motorcycles.rest

import com.elevenetc.tracker.backend.authentication.AuthenticationService
import com.elevenetc.tracker.backend.motorcycles.MotorcyclesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class MotorcyclesRestController {

    @Autowired
    lateinit var service: MotorcyclesService

    @Autowired
    lateinit var authenticationService: AuthenticationService

    @PostMapping("users/{user-id}/motorcycles")
    fun addNew(
            @RequestBody body: CreateNewMotorcycle,
            @RequestHeader("token") token: UUID,
            @PathVariable("user-id") userId: UUID
    ): MotoDto {
        return MotoDto(
                service.addNewMotorcycle(
                        body.name,
                        authenticationService.verifyAndGet(token, userId)
                )
        )
    }
}