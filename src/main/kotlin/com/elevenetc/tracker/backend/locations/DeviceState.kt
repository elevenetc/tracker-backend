package com.elevenetc.tracker.backend.locations

import com.elevenetc.tracker.backend.devices.Device
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "device_states")
class DeviceState {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null

    @Column(name = "lat")
    var lat: Double = 0.0
    @Column(name = "lon")
    var lon: Double = 0.0

    @Column(name = "battery")
    var battery: Float = 0.0f

    @Column(name = "date")
    var date: Long = 0L

    @ManyToOne
    @JoinColumn(name = "device_id")
    lateinit var device: Device


}