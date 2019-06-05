package com.elevenetc.tracker.backend.users.rest

data class RegisterUser(
        val name: String,
        val email: String,
        val password: String
)