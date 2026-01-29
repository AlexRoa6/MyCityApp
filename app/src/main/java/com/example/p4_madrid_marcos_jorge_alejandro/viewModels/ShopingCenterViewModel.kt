package com.example.p4_madrid_marcos_jorge_alejandro.viewModels

import com.example.p4_madrid_marcos_jorge_alejandro.model.ShopingCenter
import com.example.p4_madrid_marcos_jorge_alejandro.ui.views.ShopingCenterView
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class ShopingCenterUiState(
    val shopingCenters: List<ShopingCenter> = emptyList()


)

class ShopingCenterViewModel{

    private val _uiSate = MutableStateFlow(ShopingCenterUiState())
    val uiState: StateFlow<ShopingCenterUiState> =_uiSate.asStateFlow()

    fun onExpandedChange(expanded: Boolean){
        _uiSate.update {
            it.copy()
        }
    }
}