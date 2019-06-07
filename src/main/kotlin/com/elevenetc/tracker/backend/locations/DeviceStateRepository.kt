package com.elevenetc.tracker.backend.locations

import org.springframework.data.repository.CrudRepository
import java.util.*

interface DeviceStateRepository : CrudRepository<DeviceState, UUID>