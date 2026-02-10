package com.example.p4_madrid_marcos_jorge_alejandro.viewModels

import SportRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.p4_madrid_marcos_jorge_alejandro.data.OcioRepository
import com.example.p4_madrid_marcos_jorge_alejandro.model.Ocio
import com.example.p4_madrid_marcos_jorge_alejandro.model.Sport
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ocioUiState(
    val ocioList: List<Ocio> = emptyList(),
    val selectedOcio: Ocio? = null
)

class ocioViewModel(private val repository: OcioRepository): ViewModel(){

    private val _uiSate = MutableStateFlow(ocioUiState())
    val uiState: StateFlow<ocioUiState> = _uiSate.asStateFlow()

    init {
        getOcio()
    }


    fun onClickCard(ocio: Ocio){
        viewModelScope.launch {
            _uiSate.update { it.copy(selectedOcio = ocio) }
        }
    }


    fun onDismissModal(){
        viewModelScope.launch {
            _uiSate.update { it.copy(selectedOcio = null) }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                ocioViewModel(OcioRepository())
            }
        }
    }
    fun getOcio(){
        viewModelScope.launch {
            _uiSate.update { it.copy(repository.getOcio()) }
        }
    }



}


