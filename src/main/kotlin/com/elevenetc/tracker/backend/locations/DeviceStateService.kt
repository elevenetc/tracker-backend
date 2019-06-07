package com.elevenetc.tracker.backend.locations

import com.elevenetc.tracker.backend.devices.DevicesRepository
import com.elevenetc.tracker.backend.motorcycles.MotorcyclesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class DeviceStateService(
        @Autowired
        private val repository: DeviceStateRepository,
        @Autowired
        private val devicesRepository: DevicesRepository
) {
    fun save(lat: Double, lon: Double, battery: Float, deviceId: UUID) {
        repository.save(DeviceState().apply {
            this.date = Date().time
            this.lat = lat
            this.lon = lon
            this.battery = battery
            this.device = devicesRepository.findByIdOrNull(deviceId)!!
        })
    }
}