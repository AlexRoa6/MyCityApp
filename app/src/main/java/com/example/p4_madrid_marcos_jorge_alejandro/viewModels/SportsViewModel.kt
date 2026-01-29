package com.example.p4_madrid_marcos_jorge_alejandro.viewModels

import SportRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.p4_madrid_marcos_jorge_alejandro.model.Sport
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class deportesUiState(
    val deportesList: List<Sport> = emptyList()
)

class deportesViewModel(private val repository: SportRepository): ViewModel(){

    private val _uiSate = MutableStateFlow(deportesUiState())
    val uiState: StateFlow<deportesUiState> = _uiSate.asStateFlow()

    init {
        getdeportes()
    }

    fun onClickCard(deportes: Sport){
        viewModelScope.launch {
            repository.onClickCard(deportes)
        }
    }

    fun getdeportes(){
        viewModelScope.launch {
            _uiSate.update { it.copy(repository.getSports()) }
        }
    }



}

