package com.elevenetc.tracker.backend.motorcycles.rest

import com.elevenetc.tracker.backend.devices.rest.DeviceDto
import com.elevenetc.tracker.backend.motorcycles.Motorcycle
import java.util.*

class MotoDto {

    lateinit var id: UUID
    lateinit var name: String
    lateinit var deviceStates: List<DeviceDto>

    constructor(from: Motorcycle) {
        id = from.id!!
        name = from.name
        deviceStates = from.devices.map { DeviceDto(it) }
    }

    constructor()
}