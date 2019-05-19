package com.elevenetc.tracker.backend.motos

import javax.persistence.*

@Entity
@Table(name = "motorcycles")
class Motorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
}