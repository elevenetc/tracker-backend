package com.elevenetc.tracker.backend.devices.rest

import com.elevenetc.tracker.backend.devices.Device
import java.util.*

class DeviceDto {

    var id: UUID? = null
    var hardwareId: String = ""
    var name: String = ""
    var manufacturer: String = ""
    var mode: String = ""

    constructor()

    constructor(device: Device) {
        this.id = device.id
        this.hardwareId = device.hardwareId
        this.name = device.name
        this.manufacturer = device.manufacturer
        this.mode = device.mode
    }


}