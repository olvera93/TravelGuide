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



    init {
        viewModelScope.launch {
            repository.getTravelGuide(state.searchText).onSuccess {
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

    fun search() {
        viewModelScope.launch {
            repository.getTravelGuide(state.searchText).onSuccess {
                println(it)
            }.onFailure {
                println("Hubo un error")
            }
        }
    }


}