package com.elevenetc.tracker.backend.motorcycles

import org.springframework.data.repository.CrudRepository
import java.util.*

interface MotorcyclesRepository : CrudRepository<Motorcycle, UUID>