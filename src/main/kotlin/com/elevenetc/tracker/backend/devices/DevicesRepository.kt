package com.elevenetc.tracker.backend.devices

import com.elevenetc.tracker.backend.users.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface DevicesRepository : CrudRepository<Device, UUID> {
    fun getByHardwareId(hardwareId: String): Device?
    fun existsByHardwareId(hardwareId: String): Boolean
    fun getDevicesByUser(user: User): List<Device>
}