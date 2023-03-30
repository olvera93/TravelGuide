package com.olvera.travelguide.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olvera.travelguide.home.domain.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
): ViewModel() {

    init {
        viewModelScope.launch {
            repository.getTravelGuide().onSuccess {
                println(it)
            }.onFailure {
                println("Hubo un error")
            }
        }
    }



}