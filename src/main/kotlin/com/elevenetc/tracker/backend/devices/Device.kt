package com.elevenetc.tracker.backend.devices

import com.elevenetc.tracker.backend.locations.DeviceState
import com.elevenetc.tracker.backend.motorcycles.Motorcycle
import com.elevenetc.tracker.backend.users.User
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "devices")
class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null

    @Column(name = "hardware_id", unique = true)
    var hardwareId: String = ""

    @Column(name = "name")
    var name: String = ""

    @Column(name = "manufacturer")
    var manufacturer: String = ""

    @Column(name = "mode")
    var mode: String = ""

    @OneToMany(mappedBy = "device")
    lateinit var states: List<DeviceState>

    @ManyToOne
    @JoinColumn(name = "user_id")
    lateinit var user: User

    @ManyToOne
    @JoinColumn(name = "motorcycle_id")
    lateinit var motorcycle: Motorcycle

    enum class Mode {
        TRACKER("tracker"), VIEWER("viewer");

        val value: String

        constructor(value: String) {
            this.value = value
        }


        companion object {
            fun of(v: String): Mode? {
                return if (v == TRACKER.value) {
                    TRACKER
                } else if (v == VIEWER.value) {
                    VIEWER
                } else {
                    null
                }
            }
        }
    }

}