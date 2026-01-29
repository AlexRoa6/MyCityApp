package com.example.p4_madrid_marcos_jorge_alejandro.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.p4_madrid_marcos_jorge_alejandro.data.OcioRepository
import com.example.p4_madrid_marcos_jorge_alejandro.model.Ocio
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ocioUiState(
    val ocioList: List<Ocio> = emptyList()
)

class ocioViewModel(private val repository: OcioRepository): ViewModel(){

    private val _uiSate = MutableStateFlow(ocioUiState())
    val uiState: StateFlow<ocioUiState> = _uiSate.asStateFlow()

    init {
        getOcio()
    }

    fun onClickCard(ocio: Ocio){
        viewModelScope.launch {
            repository.onClickCard(ocio)
        }
    }

    fun getOcio(){
        viewModelScope.launch {
            _uiSate.update { it.copy(repository.getOcio()) }
        }
    }



}


