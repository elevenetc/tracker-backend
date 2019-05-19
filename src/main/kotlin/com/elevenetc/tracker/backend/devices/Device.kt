package com.elevenetc.tracker.backend.devices

import javax.persistence.*

@Entity
@Table(name = "devices")
class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @Column(name = "battery_level")
    var batteryLevel: Int = 0

    @Column(name = "hardware_id")
    var hardwareId: String = ""

    @Column(name = "name")
    var name: String = ""

    @Column(name = "manufacturer")
    var manufacturer: String = ""
}