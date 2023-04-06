package com.olvera.travelguide.home.presentation

import com.olvera.travelguide.home.domain.HomeFilterSettings

data class HomeState(
    val searchText: String = "",
    val showDialog: Boolean = false,
    val filterSettings: HomeFilterSettings = HomeFilterSettings(),
    val filterSettingsBackup: HomeFilterSettings = filterSettings

)
