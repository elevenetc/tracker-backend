package com.elevenetc.tracker.backend.motorcycles

import com.elevenetc.tracker.backend.devices.Device
import com.elevenetc.tracker.backend.users.User
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "motorcycles")
class Motorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null

    @Column(name = "name")
    var name: String = ""

    @ManyToOne
    @JoinColumn(name = "user_id")
    lateinit var user: User

    @OneToMany(mappedBy = "motorcycle")
    lateinit var devices: List<Device>
}