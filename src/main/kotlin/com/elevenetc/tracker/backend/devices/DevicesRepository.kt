package com.elevenetc.tracker.backend.devices

import org.springframework.data.repository.CrudRepository
import java.util.*

interface DevicesRepository : CrudRepository<Device, UUID>