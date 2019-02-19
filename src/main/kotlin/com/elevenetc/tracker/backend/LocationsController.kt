package com.elevenetc.tracker.backend

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LocationsController {
    @PostMapping("/location")
    fun location(@RequestBody location: Location) {
        println(location)
    }
}