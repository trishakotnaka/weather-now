package com.example

import kotlinx.serialization.json.*
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class WeatherService {

    private val client = HttpClient.newHttpClient()

    fun getWeather(city: String): String {
        return try {
            val url = "https://wttr.in/${city}?format=j1"

            val request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build()

            val response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
            )

            if (response.statusCode() == 200) {
                val json = Json.parseToJsonElement(response.body()).jsonObject

                val current = json["current_condition"]
                    ?.jsonArray
                    ?.firstOrNull()
                    ?.jsonObject

                val temperature = current?.get("temp_C")?.toString()?.replace("\"", "")
                val feelsLike = current?.get("FeelsLikeC")?.toString()?.replace("\"", "")
                val humidity = current?.get("humidity")?.toString()?.replace("\"", "")
                val windSpeed = current?.get("windspeedKmph")?.toString()?.replace("\"", "")

                val condition = current
                    ?.get("weatherDesc")
                    ?.jsonArray
                    ?.firstOrNull()
                    ?.jsonObject
                    ?.get("value")
                    ?.toString()
                    ?.replace("\"", "")

                """
                Weather in ${city.replaceFirstChar { it.uppercase() }}

                Temperature: ${temperature}°C
                Feels Like: ${feelsLike}°C
                Condition: $condition
                Humidity: ${humidity}%
                Wind Speed: ${windSpeed} km/h
                """.trimIndent()

            } else {
                "Unable to get weather data."
            }

        } catch (e: Exception) {
            "Error: ${e.message}"
        }
    }
}