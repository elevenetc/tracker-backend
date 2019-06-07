package com.elevenetc.tracker.backend.locations

import com.elevenetc.tracker.backend.motorcycles.Motorcycle
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "locations")
class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null

    @Column(name = "lat")
    var lat: Double = 0.0
    @Column(name = "lon")
    var lon: Double = 0.0

    @Column(name = "date")
    var date: Long = 0L

    @ManyToOne
    @JoinColumn(name = "motorcycle_id")
    lateinit var motorcycle: Motorcycle


}