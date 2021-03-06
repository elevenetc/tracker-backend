package com.elevenetc.tracker.backend.devices.rest

import com.elevenetc.tracker.backend.authentication.AuthenticationService
import com.elevenetc.tracker.backend.devices.Device
import com.elevenetc.tracker.backend.devices.DevicesService
import com.elevenetc.tracker.backend.locations.DeviceStateService
import com.elevenetc.tracker.backend.locations.rest.DeviceStateBody
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class DevicesRestController {

    @Autowired
    lateinit var devicesService: DevicesService

    @Autowired
    lateinit var devicesStateService: DeviceStateService

    @Autowired
    lateinit var authenticationService: AuthenticationService


    @PostMapping("users/{user-id}/devices")
    fun addDevice(
            @RequestBody device: CreateDeviceDto,
            @RequestHeader("access-token") token: UUID,
            @PathVariable("user-id") userId: UUID
    ): DeviceDto {

        val user = authenticationService.verifyAndGet(token, userId)

        return DeviceDto(
                devicesService.addDevice(user, device.hardwareId, device.manufacturer, device.name)
        )
    }

    @GetMapping("users/{user-id}/devices/{device-id}")
    fun getDevice(
            @RequestHeader("access-token") token: UUID,
            @PathVariable("user-id") userId: UUID,
            @PathVariable("device-id") deviceId: UUID
    ): DeviceDto {

        authenticationService.verify(token, userId)

        return DeviceDto(devicesService.getDevice(deviceId))
    }

    @GetMapping("users/{user-id}/devices")
    fun getDevices(
            @RequestHeader("access-token") token: UUID,
            @PathVariable("user-id") userId: UUID
    ): List<DeviceDto> {

        val user = authenticationService.verifyAndGet(token, userId)

        return devicesService.getDevices(user).map { DeviceDto(it) }
    }

    @PostMapping("users/{user-id}/devices/{device-id}/mode")
    fun setMode(
            @RequestBody body: UpdateMode,
            @RequestHeader("access-token") token: UUID,
            @PathVariable("user-id") userId: UUID,
            @PathVariable("device-id") deviceId: UUID
    ) {

        authenticationService.verify(token, userId)

        val mode = Device.Mode.of(body.newMode)

        if (mode == null) {
            throw RuntimeException("Invalid mode: $mode. Available: ")
        } else {
            devicesService.setMode(mode, deviceId)
        }
    }

    @PatchMapping("users/{user-id}/devices/{device-id}/state")
    fun state(
            @RequestBody body: DeviceStateBody,
            @RequestHeader("access-token") token: UUID,
            @PathVariable("user-id") userId: UUID,
            @PathVariable("device-id") deviceId: UUID
    ) {
        authenticationService.verify(token, userId)
        devicesStateService.save(body.lat, body.lon, body.battery, deviceId)
    }
}