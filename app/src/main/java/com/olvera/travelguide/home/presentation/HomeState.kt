package com.olvera.travelguide.home.presentation

import com.olvera.travelguide.home.domain.model.HomeFilterSettings
import com.olvera.travelguide.home.domain.model.Place
import com.olvera.travelguide.home.domain.model.Region

data class HomeState(
    val searchText: String = "",
    val showDialog: Boolean = false,
    val filterSettings: HomeFilterSettings = HomeFilterSettings(),
    val filterSettingsBackup: HomeFilterSettings = filterSettings,
    val chatReply: String? = null,
    val selectedRegion: Region = Region.ALL,
    val popularPlaces: List<Place> = emptyList(),
    val popularPlacesBackup: List<Place> = popularPlaces,
    val isLoading: Boolean = false
)
