package com.olvera.travelguide.home.domain

import com.olvera.travelguide.home.domain.model.HomeFilterSettings
import com.olvera.travelguide.home.domain.model.Place

interface HomeRepository {
    suspend fun getTravelGuide(location: String, settings: HomeFilterSettings): Result<String>

    suspend fun getPopularPlaces(): Result<List<Place>>

}