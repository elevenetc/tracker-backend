package com.elevenetc.tracker.backend.locations

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LocationsService(
        @Autowired
        private val repository: LocationsRepository
) {
    fun save(location: Location) {
        repository.save(location)
    }

    fun getAll(): List<Location> {
        return repository.findAll().toList()
    }
}