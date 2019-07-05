package com.elevenetc.tracker.backend.users.rest

data class LoginDto(
        val email: String,
        val password: String
)