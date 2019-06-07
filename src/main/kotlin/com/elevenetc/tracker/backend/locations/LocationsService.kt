package com.elevenetc.tracker.backend.locations

import com.elevenetc.tracker.backend.motorcycles.MotorcyclesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class LocationsService(
        @Autowired
        private val repository: LocationsRepository,
        @Autowired
        private val motorcyclesRepository: MotorcyclesRepository
) {
    fun save(lat: Double, lon: Double, motorcycleId: UUID) {
        repository.save(Location().apply {
            this.date = Date().time
            this.lat = lat
            this.lon = lon
            this.motorcycle = motorcyclesRepository.findByIdOrNull(motorcycleId)!!
        })
    }

    fun getAll(): List<Location> {
        return repository.findAll().toList()
    }
}