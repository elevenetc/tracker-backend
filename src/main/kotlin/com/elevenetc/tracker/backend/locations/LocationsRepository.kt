package com.elevenetc.tracker.backend.locations

import org.springframework.data.repository.CrudRepository

interface LocationsRepository : CrudRepository<Location, Long>