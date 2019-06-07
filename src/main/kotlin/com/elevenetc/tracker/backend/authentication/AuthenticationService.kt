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

    fun verify(token: UUID) {
        if (!tokensRepository.existsByValue(token)) {
            throw RuntimeException("Invalid token $token")
        }
    }

    fun verifyAndGetId(token: UUID): UUID {
        return verifyAndGet(token).id!!
    }

    fun verifyAndGet(token: UUID): User {

        if (tokensRepository.existsByValue(token)) {
            return tokensRepository.getByValue(token).user
        } else {
            throw RuntimeException("Invalid token $token")
        }
    }
}