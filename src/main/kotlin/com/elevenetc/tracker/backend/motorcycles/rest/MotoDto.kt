package com.elevenetc.tracker.backend.motorcycles.rest

import com.elevenetc.tracker.backend.locations.rest.LocationDto
import com.elevenetc.tracker.backend.motorcycles.Motorcycle
import java.util.*

class MotoDto {

    lateinit var id: UUID
    lateinit var name: String
    lateinit var locations: List<LocationDto>

    constructor(from: Motorcycle) {
        id = from.id!!
        name = from.name
        locations = from.locations.map { LocationDto(it) }
    }

    constructor()
}