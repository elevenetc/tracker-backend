package com.elevenetc.tracker.backend.devices.rest

import com.elevenetc.tracker.backend.authentication.AuthenticationService
import com.elevenetc.tracker.backend.devices.Device
import com.elevenetc.tracker.backend.devices.DevicesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DevicesRestController {

    @Autowired
    lateinit var devicesService: DevicesService

    @Autowired
    lateinit var authenticationService: AuthenticationService

    @PostMapping("/device/mode")
    fun setMode(@RequestBody body: SetMode) {
        authenticationService.verify(body.token)


        val mode = Device.Mode.of(body.mode)

        if (mode == null) {
            throw RuntimeException("Invalid mode: $mode")
        } else {
            devicesService.setMode(mode, body.deviceId)
        }
    }
}