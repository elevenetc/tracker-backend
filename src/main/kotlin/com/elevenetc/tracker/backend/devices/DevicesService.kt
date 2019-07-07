package com.elevenetc.tracker.backend.devices

import com.elevenetc.tracker.backend.users.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class DevicesService {

    @Autowired
    lateinit var devicesRepository: DevicesRepository

    fun addDevice(user: User, hardwareId: String, manufacturer: String, name: String): Device {

        return if (devicesRepository.existsByHardwareId(hardwareId)) {
            devicesRepository.getByHardwareId(hardwareId)!!
        } else {
            devicesRepository.save(Device().apply {
                this.hardwareId = hardwareId
                this.manufacturer = manufacturer
                this.name = name
                this.user = user
            })
        }


    }

    fun setMode(mode: Device.Mode, deviceId: UUID) {
        val device = devicesRepository.findByIdOrNull(deviceId)
        if (device == null) {
            throw RuntimeException("Device not found: $deviceId")
        } else {
            device.mode = mode.value
            devicesRepository.save(device)

            //TODO: make push to updated device
        }
    }

    fun getDevices(user: User): List<Device> {
        return devicesRepository.getDevicesByUser(user)
    }
}