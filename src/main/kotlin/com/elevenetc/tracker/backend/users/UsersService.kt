package com.elevenetc.tracker.backend.users

import com.elevenetc.tracker.backend.authentication.AccessToken
import com.elevenetc.tracker.backend.authentication.AccessTokensRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.security.MessageDigest
import java.util.*

@Service
class UsersService(
        @Autowired private val usersRepository: UsersRepository,
        @Autowired private val tokensRepository: AccessTokensRepository
) {

    private val md5 = MessageDigest.getInstance("MD5")

    fun delete(id: String) {
        usersRepository.deleteById(id.toLong())
    }

    fun login(email: String, password: String): UUID {
        if (usersRepository.existsByEmail(email)) {

            val user = usersRepository.getByEmail(email)

            val hashedPassword = hashPassword(password, user.passwordSalt)
            if (hashedPassword != user.password) {
                throw RuntimeException("invalid password for $email")
            }

            return createNewToken(user)
        } else {
            throw RuntimeException("user $email doesn't exitst")
        }
    }

    fun createNewUser(email: String, password: String, name: String): UUID {

        val salt = UUID.randomUUID().toString()
        val hashedPassword = hashPassword(password, salt)

        val user = usersRepository.save(User().apply {
            this.email = email
            this.name = name
            this.passwordSalt = salt
            this.password = hashedPassword
        })

        return createNewToken(user)
    }


    fun getAll(): List<User> {
        return usersRepository.findAll().toList()
    }

    private fun hashPassword(password: String, salt: String): String {
        return String(md5.digest((password + salt).toByteArray()))
    }

    private fun createNewToken(user: User): UUID {
        val token = UUID.randomUUID()

        tokensRepository.save(AccessToken().apply {
            this.user = user
            this.value = token
            this.date = Date().time
        })
        return token
    }
}