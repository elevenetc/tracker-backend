package com.elevenetc.tracker.backend.authentication

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

    fun verify(token: UUID): com.elevenetc.tracker.backend.users.User {

        if (tokensRepository.existsByValue(token)) {
            return tokensRepository.getByValue(token).user
        } else {
            throw RuntimeException("Invalid token $token")
        }
    }
}