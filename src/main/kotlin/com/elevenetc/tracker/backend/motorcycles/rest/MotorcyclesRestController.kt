package com.elevenetc.tracker.backend.motorcycles.rest

import com.elevenetc.tracker.backend.authentication.AuthenticationService
import com.elevenetc.tracker.backend.motorcycles.MotorcyclesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class MotorcyclesRestController {

    @Autowired
    lateinit var service: MotorcyclesService

    @Autowired
    lateinit var authenticationService: AuthenticationService

    @PostMapping("/motorcycle")
    fun addNew(@RequestBody body: CreateNewMotorcycle): MotoDto {
        return MotoDto(
                service.addNewMotorcycle(
                        body.name,
                        authenticationService.verifyAndGet(UUID.fromString(body.token))
                )
        )
    }
}