package com.elevenetc.tracker.backend.users.rest

import com.elevenetc.tracker.backend.motorcycles.rest.MotoDto
import java.util.*

data class UserDto(
        val token: UUID,
        val motorcycles: List<MotoDto> = emptyList()
)