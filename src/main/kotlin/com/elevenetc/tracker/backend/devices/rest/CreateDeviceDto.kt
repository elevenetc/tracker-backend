package com.elevenetc.tracker.backend.devices.rest

data class CreateDeviceDto(
        val hardwareId: String,
        val manufacturer: String,
        val name: String
)