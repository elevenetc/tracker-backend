package com.elevenetc.tracker.backend.motorcycles

import com.elevenetc.tracker.backend.users.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MotorcyclesService(
        @Autowired val motoRepository: MotorcyclesRepository
) {
    fun addNewMotorcycle(name: String, user: User): Long {
        return motoRepository.save(Motorcycle().apply {
            this.name = name
            this.user = user
        }).id
    }

    fun removeMotorcycle(id: Long) {
        motoRepository.deleteById(id)
    }

    fun updateName(name: String, id: Long) {
        motoRepository.findByIdOrNull(id)?.let {
            motoRepository.save(it.apply { this.name = name })
        }
    }
}