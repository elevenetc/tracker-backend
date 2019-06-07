package com.elevenetc.tracker.backend.locations.rest

import com.elevenetc.tracker.backend.locations.DeviceState
import java.util.*

class DeviceStateDto {

    lateinit var id: UUID
    lateinit var deviceId: UUID

    var lat: Double = 0.0
    var lon: Double = 0.0
    var date: Long = 0L
    var battery: Float = 0.0f

    constructor(from: DeviceState) {
        lat = from.lat
        lon = from.lon
        date = from.date
        id = from.id!!
        deviceId = from.device.id!!
        battery = from.battery
    }

    constructor()
}