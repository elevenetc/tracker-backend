package com.elevenetc.tracker.backend.users

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

    @Column(name = "email")
    var email: String = ""

    @Column(name = "password")
    var password: String = ""

    @Column(name = "password_salt")
    var passwordSalt: String = ""

    @OneToMany(mappedBy = "user")
    lateinit var motorcycles: List<Motorcycle>
}