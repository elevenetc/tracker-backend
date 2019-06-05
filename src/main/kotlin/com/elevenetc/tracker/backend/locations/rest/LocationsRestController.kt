package com.elevenetc.tracker.backend.locations.rest

import com.elevenetc.tracker.backend.locations.Location
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

    @PostMapping("/location")
    fun location(@RequestBody location: LocationBody) {
        val loc = Location()
        loc.lat = location.lat
        loc.lon = location.lon
        locationsService.save(loc)
    }

    @GetMapping("/location")
    fun locations(): List<LocationDto> {
        return locationsService.getAll().map {
            LocationDto(it.lat, it.lon)
        }
    }
}