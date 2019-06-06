package com.elevenetc.tracker.backend.users.rest

data class Logout(
        val email: String,
        val token: String
)