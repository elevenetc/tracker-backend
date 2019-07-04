package com.elevenetc.tracker.backend.devices.rest

import com.elevenetc.tracker.backend.authentication.AuthenticationService
import com.elevenetc.tracker.backend.devices.Device
import com.elevenetc.tracker.backend.devices.DevicesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class DevicesRestController {

    @Autowired
    lateinit var devicesService: DevicesService

    @Autowired
    lateinit var authenticationService: AuthenticationService


    @PostMapping("/device")
    fun addDevice(device: CreateDeviceDto, @RequestHeader("Token") token: UUID): DeviceDto {
        val user = authenticationService.verifyAndGet(token)

        return DeviceDto(
                devicesService.addDevice(user, device.hardwareId, device.manufacturer, device.name)
        )
    }

    @PostMapping("/device/mode")
    fun setMode(@RequestBody body: SetMode, @RequestHeader("Token") token: UUID) {

        authenticationService.verify(token)


        val mode = Device.Mode.of(body.mode)

        if (mode == null) {
            throw RuntimeException("Invalid mode: $mode")
        } else {
            devicesService.setMode(mode, body.deviceId)
        }
    }
}