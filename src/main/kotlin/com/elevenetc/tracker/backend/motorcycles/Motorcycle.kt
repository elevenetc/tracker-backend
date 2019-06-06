package com.elevenetc.tracker.backend.motorcycles

import com.elevenetc.tracker.backend.locations.Location
import com.elevenetc.tracker.backend.users.User
import javax.persistence.*


@Entity
@Table(name = "motorcycles")
class Motorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @Column(name = "name")
    var name: String = ""

    @ManyToOne
    @JoinColumn(name = "user_id")
    lateinit var user: User

    @OneToMany(mappedBy = "motorcycle")
    lateinit var locations: List<Location>
}