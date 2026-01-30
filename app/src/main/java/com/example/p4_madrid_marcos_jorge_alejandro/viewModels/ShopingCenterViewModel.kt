package com.example.p4_madrid_marcos_jorge_alejandro.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.lifecycle.viewModelScope
import com.example.p4_madrid_marcos_jorge_alejandro.data.ShopingCenterRepository
import com.example.p4_madrid_marcos_jorge_alejandro.model.ShopingCenter
import com.example.p4_madrid_marcos_jorge_alejandro.ui.views.ShopingCenterView
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


data class ShopingCenterUiState(
    val shopingCenters: List<ShopingCenter> = emptyList(),
    val shopingCenterSelected: ShopingCenter? = null
)

class ShopingCenterViewModel(private val repository: ShopingCenterRepository): ViewModel(){

    private val _uiSate = MutableStateFlow(ShopingCenterUiState())
    val uiState: StateFlow<ShopingCenterUiState> =_uiSate.asStateFlow()


    init {
        getShopingCenters()
    }

    fun onClickCard(shopingCenter: ShopingCenter){
        viewModelScope.launch {
            _uiSate.update { it.copy(shopingCenterSelected = shopingCenter) }
        }
    }

    fun getShopingCenters(){
        viewModelScope.launch {
            _uiSate.update { it.copy(repository.getShopingCenters()) }
        }
    }

    fun onDismissModal(){
        viewModelScope.launch {
            _uiSate.update { it.copy(shopingCenterSelected = null) }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                ShopingCenterViewModel(ShopingCenterRepository())
            }
        }
    }
}