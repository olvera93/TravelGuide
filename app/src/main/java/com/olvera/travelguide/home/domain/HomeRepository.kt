package com.olvera.travelguide.home.domain

interface HomeRepository {

    suspend fun getTravelGuide(location: String): Result<String>
}