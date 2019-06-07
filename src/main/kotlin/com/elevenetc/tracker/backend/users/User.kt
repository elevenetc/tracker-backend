package com.elevenetc.tracker.backend.users

import com.elevenetc.tracker.backend.authentication.AccessToken
import com.elevenetc.tracker.backend.motorcycles.Motorcycle
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null

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

    @OneToMany(mappedBy = "user")
    lateinit var accessTokens: List<AccessToken>
}