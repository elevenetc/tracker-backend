package com.elevenetc.tracker.backend.motos

import com.elevenetc.tracker.backend.users.User
import javax.persistence.*


@Entity
@Table(name = "motorcycles")
class Motorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @Column(name = "owner_id")
    var ownerId: Long = 0L

    @Column(name = "name")
    var name: String = ""


    @ManyToOne
    @JoinColumn(name = "user_id")
    lateinit var user: User
}