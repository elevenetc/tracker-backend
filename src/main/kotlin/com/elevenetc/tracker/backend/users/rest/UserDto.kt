package com.elevenetc.tracker.backend.users.rest

import com.elevenetc.tracker.backend.devices.rest.DeviceDto
import com.elevenetc.tracker.backend.motorcycles.rest.MotoDto
import java.util.*

data class UserDto(
        val accessToken: UUID,
        val userId:UUID,
        val motorcycles: List<MotoDto> = emptyList(),
        val devices:List<DeviceDto> = emptyList()
)