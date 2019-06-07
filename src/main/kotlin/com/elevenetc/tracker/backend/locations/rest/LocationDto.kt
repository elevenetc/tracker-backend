package com.elevenetc.tracker.backend.locations.rest

import com.elevenetc.tracker.backend.locations.Location
import java.util.*

class LocationDto {

    lateinit var id: UUID
    var lat: Double = 0.0
    var lon: Double = 0.0
    var date: Long = 0L



    constructor(from: Location) {
        lat = from.lat
        lon = from.lon
        date = from.date
        id = from.id!!
    }

    constructor()
}