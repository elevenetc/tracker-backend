package com.elevenetc.tracker.backend.locations.rest

import java.util.*

data class DeviceStateBody(
        val lat: Double,
        val lon: Double,
        val battery: Float,
        val deviceId: UUID
)