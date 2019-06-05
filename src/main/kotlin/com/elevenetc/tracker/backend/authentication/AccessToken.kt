package com.elevenetc.tracker.backend.authentication

import com.elevenetc.tracker.backend.users.User
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*

@Entity(name = "access_tokens")
class AccessToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @Column(name = "date")
    var date: Long = 0L

    @Column(name = "value")
    @Type(type = "uuid-char")
    lateinit var value: UUID

    @ManyToOne
    @JoinColumn(name = "user_id")
    lateinit var user: User
}