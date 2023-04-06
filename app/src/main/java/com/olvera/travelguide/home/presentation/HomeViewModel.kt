package com.olvera.travelguide.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olvera.travelguide.home.domain.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    fun search() {
        viewModelScope.launch {
            repository.getTravelGuide(state.searchText, state.filterSettings).onSuccess {
                println(it)
            }.onFailure {
                println("Hubo un error")
            }
        }
    }

    fun onSearchTextChange(newText: String) {
        state = state.copy(
            searchText = newText
        )
    }

    fun onSettingsChange(action: HomeFilterDialogActions) {
        when (action) {
            HomeFilterDialogActions.OnApplyClick -> {
                state = state.copy(
                    filterSettingsBackup = state.filterSettings,
                    showDialog = false
                )
            }
            HomeFilterDialogActions.OnMuseumClick -> {
                state = state.copy(
                    filterSettings = state.filterSettings.copy(
                        museums = !state.filterSettings.museums
                    )
                )
            }
            HomeFilterDialogActions.OnPeopleMinus -> {
                state = state.copy(
                    filterSettings = state.filterSettings.copy(
                        people = state.filterSettings.people - 1
                    )
                )
            }
            HomeFilterDialogActions.OnPeoplePlus -> {
                state = state.copy(
                    filterSettings = state.filterSettings.copy(
                        people = state.filterSettings.people + 1
                    )
                )
            }
            HomeFilterDialogActions.OnRestaurantClick -> {
                state = state.copy(
                    filterSettings = state.filterSettings.copy(
                        restaurant = !state.filterSettings.restaurant
                    )
                )
            }
        }
    }

    fun onFilterClick() {
        state = state.copy(
            showDialog = true
        )
    }

    fun onFilterDismiss() {
        state = state.copy(
            showDialog = false,
            filterSettings = state.filterSettingsBackup
        )
    }

}