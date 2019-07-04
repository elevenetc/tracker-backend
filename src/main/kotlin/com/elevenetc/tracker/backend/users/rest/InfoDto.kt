package com.elevenetc.tracker.backend.users.rest

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer
import java.util.*

class InfoDto {
    @JsonSerialize(using = UUIDSerializer::class)
    @JsonDeserialize(using = UUIDDeserializer::class)
    lateinit var token: UUID
}