package com.elevenetc.tracker.backend

import com.elevenetc.tracker.backend.motos.Motorcycle
import javax.persistence.*

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @Column(name = "name")
    var name: String = ""

    @OneToMany(mappedBy = "users")
    lateinit var motorcycles: List<Motorcycle>
}