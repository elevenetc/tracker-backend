package com.elevenetc.tracker.backend.users

import com.elevenetc.tracker.backend.authentication.AccessToken
import com.elevenetc.tracker.backend.authentication.AccessTokensRepository
import com.elevenetc.tracker.backend.devices.Device
import com.elevenetc.tracker.backend.devices.DevicesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.security.MessageDigest
import java.util.*

@Service
class UsersService(
        @Autowired private val usersRepository: UsersRepository,
        @Autowired private val tokensRepository: AccessTokensRepository,
        @Autowired private val devicesRepository: DevicesRepository
) {

    private val md5 = MessageDigest.getInstance("MD5")

    fun getUser(id: UUID): User {
        return usersRepository.findByIdOrNull(id)!!
    }

    fun login(
            email: String, password: String
    ): Pair<AccessToken, User> {
        if (usersRepository.existsByEmail(email)) {
            val user = usersRepository.getByEmail(email)
            val token = createNewToken(user)
            checkPassword(password, user, email)
            return Pair(token, user)
        } else {
            throw RuntimeException("user $email doesn't exitst")
        }
    }

    fun logout(userId: UUID, token: UUID) {
        if (usersRepository.existsById(userId)) {
            tokensRepository.delete(tokensRepository.getByValue(token))
        }
    }

    fun register(
            email: String,
            password: String
    ): Pair<AccessToken, User> {

        println("register method")

        if (usersRepository.existsByEmail(email))
            throw RuntimeException("user with $email already exists")


        val salt = UUID.randomUUID().toString()
        val hashedPassword = hashPassword(password, salt)

        println("saving...")

        val user = usersRepository.save(User().apply {
            this.email = email
            this.name = ""
            this.passwordSalt = salt
            this.password = hashedPassword
        })

        println("saved...")
        println("creating token...")

        val token = createNewToken(user)

        println("created token")

        return Pair(token, user)
    }

    private fun createDevice(deviceHardwareId: String, deviceManufacturer: String, deviceName: String, user: User) {
        devicesRepository.save(Device().apply {
            this.hardwareId = deviceHardwareId
            this.manufacturer = deviceManufacturer
            this.name = deviceName
            this.user = user
            this.mode = "viewer"
        })
    }

    private fun hashPassword(password: String, salt: String): String {
        return String(md5.digest((password + salt).toByteArray()))
    }

    private fun createNewToken(user: User): AccessToken {
        val token = UUID.randomUUID()

        return tokensRepository.save(AccessToken().apply {
            this.user = user
            this.value = token
            this.date = Date().time
        })
    }

    private fun checkPassword(password: String, user: User, email: String) {
        val hashedPassword = hashPassword(password, user.passwordSalt)
        if (hashedPassword != user.password) {
            throw RuntimeException("invalid password for $email")
        }
    }
}