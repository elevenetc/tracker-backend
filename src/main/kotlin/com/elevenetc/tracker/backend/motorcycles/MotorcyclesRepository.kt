package com.elevenetc.tracker.backend.motorcycles

import org.springframework.data.repository.CrudRepository

interface MotorcyclesRepository : CrudRepository<Motorcycle, Long>