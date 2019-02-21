package com.elevenetc.tracker.backend.locations

import javax.persistence.*


@Entity
@Table(name = "locations")
class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @Column(name = "lat")
    var lat: Double = 0.0
    @Column(name = "lon")
    var lon: Double = 0.0

    @Column(name = "motoId")
    var motoId: Long = 0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Location

        if (id != other.id) return false
        if (lat != other.lat) return false
        if (lon != other.lon) return false
        if (motoId != other.motoId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + lat.hashCode()
        result = 31 * result + lon.hashCode()
        result = 31 * result + motoId.hashCode()
        return result
    }


}