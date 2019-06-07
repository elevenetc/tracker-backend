package com.elevenetc.tracker.backend.locations.rest

import com.elevenetc.tracker.backend.authentication.AuthenticationService
import com.elevenetc.tracker.backend.locations.DeviceStateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DeviceStateRestController {

    @Autowired
    lateinit var deviceStateService: DeviceStateService

    @Autowired
    lateinit var authenticationService: AuthenticationService

    @PostMapping("/device/state")
    fun state(@RequestBody body: DeviceStateBody) {
        authenticationService.verifyAndGet(body.token)
        deviceStateService.save(body.lat, body.lon, body.battery, body.deviceId)
    }
}