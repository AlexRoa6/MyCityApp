package com.example.p4_madrid_marcos_jorge_alejandro.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_madrid_marcos_jorge_alejandro.R
import com.example.p4_madrid_marcos_jorge_alejandro.ui.components.GenericScreenContent
import com.example.p4_madrid_marcos_jorge_alejandro.viewModels.ShopingCenterViewModel

@Composable
fun ShopingCenterView(onClickNavigation: (String) -> Unit, onBackButtonClicked: () -> Unit, viewModel: ShopingCenterViewModel = viewModel(factory = ShopingCenterViewModel.Factory)) {
    val uiState by viewModel.uiState.collectAsState()

    GenericScreenContent(
        items = uiState.shopingCenters,
        selectedItem = uiState.shopingCenterSelected,
        onClickCard = { viewModel.onClickCard(it) },
        onDismissModal = { viewModel.onDismissModal() },
        titleRes = R.string.title_centros_comerciales,
        descriptionRes = R.string.centros_comerciales_description,
        topBarTitleRes = R.string.centros_comerciales_topBar,
        onBackButtonClicked = { onBackButtonClicked() },
        currentDestination = AppDestination.SHOPING_CENTER,
        onClickNavigation = { onClickNavigation(it.label) }
    )
}

