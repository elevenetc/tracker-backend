package com.elevenetc.tracker.backend.devices

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class DevicesService {

    @Autowired
    lateinit var devicesRepository: DevicesRepository

    fun setMode(mode: Device.Mode, deviceId: UUID) {
        val device = devicesRepository.findByIdOrNull(deviceId)
        if (device == null) {
            throw RuntimeException("Device not found: $deviceId")
        } else {
            device.mode = mode.value
            devicesRepository.save(device)
        }
    }
}