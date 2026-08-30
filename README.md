# 🌦️ Weather Now

A simple RESTful Weather API built using **Kotlin** and **Ktor**.  
The application fetches real-time weather information for a given city and provides it through a clean API endpoint.

## 🚀 Features

- 🌡️ Current temperature
- 🤗 Feels-like temperature
- ☁️ Weather condition
- 💧 Humidity
- 💨 Wind speed
- 🌍 Weather information by city
- 🔗 RESTful API endpoint
- 📦 JSON response support
- ⚡ Built with Kotlin and Ktor

## 🛠️ Technologies Used

- **Kotlin**
- **Ktor**
- **Gradle**
- **Kotlinx Serialization**
- **REST API**
- **JSON**
- **Git & GitHub**

## 📁 Project Structure

```text
weather-now/
├── src/
│   ├── main/
│   │   ├── kotlin/
│   │   │   ├── Http.kt
│   │   │   ├── main.kt
│   │   │   ├── Routing.kt
│   │   │   ├── Serialization.kt
│   │   │   └── WeatherService.kt
│   │   └── resources/
│   │       ├── application.yaml
│   │       └── logback.xml
│   └── test/
├── gradle/
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
└── settings.gradle.kts