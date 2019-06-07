package com.elevenetc.tracker.backend.locations.rest

import java.util.*

data class LocationBody(
        val lat: Double,
        val lon: Double,
        val motorcycleId: UUID,
        val token: UUID
)