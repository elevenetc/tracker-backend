package com.elevenetc.tracker.backend

import com.elevenetc.tracker.backend.locations.DeviceStateService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext
import java.nio.charset.Charset


@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = ["classpath:application-tests.properties"])
class AppTests {


    val contentType = MediaType(MediaType.APPLICATION_JSON.type, MediaType.APPLICATION_JSON.subtype, Charset.forName("utf8"))

    @Autowired
    lateinit var context: WebApplicationContext

    @Autowired
    lateinit var app: MockMvc

    @MockBean
    lateinit var service: DeviceStateService


    @Before
    @Throws(Exception::class)
    fun setup() {

    }

    @Test
    fun test() {
//        val asJsonString = asJsonString(DeviceStateBody(.1, .1, "1"))
//        app.perform(
//                post("/location")
//                        .contentType(contentType)
//                        .content(asJsonString)
//        ).andExpect(status().isOk)
//
//        val location = DeviceState()
//        location.lat = .1
//        location.lon = .1
//        Mockito.verify(service, times(1)).save(location)
    }

    fun asJsonString(obj: Any): String {
        return ObjectMapper().writeValueAsString(obj)
    }


}