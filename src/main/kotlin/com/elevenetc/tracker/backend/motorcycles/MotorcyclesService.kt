package com.elevenetc.tracker.backend.motorcycles

import com.elevenetc.tracker.backend.users.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MotorcyclesService(
        @Autowired val motoRepository: MotorcyclesRepository
) {
    fun addNewMotorcycle(name: String, user: User): Motorcycle {
        return motoRepository.save(Motorcycle().apply {
            this.name = name
            this.user = user
        })
    }
}