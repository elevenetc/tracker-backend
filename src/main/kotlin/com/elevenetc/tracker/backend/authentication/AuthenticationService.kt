package com.elevenetc.tracker.backend.authentication

import com.elevenetc.tracker.backend.users.User
import com.elevenetc.tracker.backend.users.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthenticationService {

    @Autowired
    lateinit var usersService: UsersService

    @Autowired
    lateinit var tokensRepository: AccessTokensRepository

    fun verify(token: UUID, userId: UUID) {
        val exists = tokensRepository.existsByValue(token)
        val accessToken = tokensRepository.getByValue(token)
        val user = accessToken.user
        if (!exists || user.id != userId) {
            throw RuntimeException("Invalid accessToken $accessToken")
        }
    }

    fun verifyAndGet(token: UUID, userId: UUID): User {

        if (tokensRepository.existsByValue(token)) {
            return tokensRepository.getByValue(token).user
        } else {
            throw RuntimeException("Invalid accessToken $token")
        }
    }
}