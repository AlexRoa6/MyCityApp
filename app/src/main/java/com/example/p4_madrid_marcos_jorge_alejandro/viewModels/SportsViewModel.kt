package com.example.p4_madrid_marcos_jorge_alejandro.viewModels

import SportRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.p4_madrid_marcos_jorge_alejandro.data.ShopingCenterRepository
import com.example.p4_madrid_marcos_jorge_alejandro.model.ShopingCenter
import com.example.p4_madrid_marcos_jorge_alejandro.model.Sport
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class deportesUiState(
    val deportesList: List<Sport> = emptyList(),
    val selectedSport: Sport? = null
)

class deportesViewModel(private val repository: SportRepository): ViewModel(){

    private val _uiSate = MutableStateFlow(deportesUiState())
    val uiState: StateFlow<deportesUiState> = _uiSate.asStateFlow()

    init {
        getdeportes()
    }


    fun onClickCard(sport: Sport){
        viewModelScope.launch {
            _uiSate.update { it.copy(selectedSport = sport) }
        }
    }


    fun onDismissModal(){
        viewModelScope.launch {
            _uiSate.update { it.copy(selectedSport = null) }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                deportesViewModel(SportRepository())
            }
        }
    }
    fun getdeportes(){
        viewModelScope.launch {
            _uiSate.update { it.copy(repository.getSports()) }
        }
    }



}

