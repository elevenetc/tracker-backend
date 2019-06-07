package com.elevenetc.tracker.backend.users.rest

import com.elevenetc.tracker.backend.devices.rest.DeviceDto

data class Login(
        val email: String,
        val password: String,
        val device: DeviceDto
)