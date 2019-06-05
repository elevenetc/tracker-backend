package com.elevenetc.tracker.backend.users.rest

data class CreateUser(
        val name: String,
        val email: String,
        val password: String
)