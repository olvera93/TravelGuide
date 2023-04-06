package com.olvera.travelguide.home.domain.model

data class Place(
    val country: String,
    val city: String,
    val region: Region,
    val image: String

)

enum class Region {
    ALL,
    AMERICA,
    ASIA,
    EUROPE,
    OCEANIA
}
