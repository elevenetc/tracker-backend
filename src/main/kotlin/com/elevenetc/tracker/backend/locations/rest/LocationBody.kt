package com.elevenetc.tracker.backend.locations.rest

data class LocationBody(
        val lat: Double,
        val lon: Double,
        val motoId: String
)