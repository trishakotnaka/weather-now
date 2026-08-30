package com.example

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    val weatherService = WeatherService()

    routing {

        get("/") {
            call.respondText("Weather API is running!")
        }

        get("/weather/{city}") {
            val city = call.parameters["city"]

            if (city == null) {
                call.respondText("Please provide a city")
            } else {
                val weather = weatherService.getWeather(city)
                call.respondText(weather)
            }
        }
    }
}