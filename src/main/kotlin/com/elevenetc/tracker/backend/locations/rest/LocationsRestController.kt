package com.elevenetc.tracker.backend.locations.rest

import com.elevenetc.tracker.backend.locations.Location
import com.elevenetc.tracker.backend.locations.LocationsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LocationsRestController {

    @Autowired
    lateinit var locations: LocationsService

    @PostMapping("/location")
    fun location(@RequestBody location: LocationBody) {
        val loc = Location()
        loc.lat = location.lat
        loc.lon = location.lon
        loc.motoId = location.motoId.toLong()
        locations.save(loc)
    }
}