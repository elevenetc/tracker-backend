package com.elevenetc.tracker.backend.devices.rest

import com.elevenetc.tracker.backend.authentication.rest.TokenBody
import java.util.*

class SetMode : TokenBody() {
    lateinit var mode: String
    lateinit var deviceId:UUID
}