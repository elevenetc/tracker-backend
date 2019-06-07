package com.elevenetc.tracker.backend.locations.rest

import com.elevenetc.tracker.backend.authentication.AuthenticationService
import com.elevenetc.tracker.backend.locations.LocationsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LocationsRestController {

    @Autowired
    lateinit var locationsService: LocationsService

    @Autowired
    lateinit var authenticationService: AuthenticationService

    @PostMapping("/location")
    fun location(@RequestBody body: LocationBody) {
        authenticationService.verifyAndGet(body.token)
        locationsService.save(body.lat, body.lon, body.motorcycleId)
    }

    @GetMapping("/location")
    fun locations(): List<LocationDto> {
        return locationsService.getAll().map {
            LocationDto(it)
        }
    }
}