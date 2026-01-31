package com.example.p4_madrid_marcos_jorge_alejandro.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_madrid_marcos_jorge_alejandro.R
import com.example.p4_madrid_marcos_jorge_alejandro.ui.components.GenericScreenContent
import com.example.p4_madrid_marcos_jorge_alejandro.viewModels.deportesViewModel

@Composable
fun SportsView(onClickNavigation: (String) -> Unit, onBackButtonClicked: () -> Unit, viewModel: deportesViewModel = viewModel(factory = deportesViewModel.Factory)){
    val uiState by viewModel.uiState.collectAsState()

    GenericScreenContent(
        items = uiState.deportesList,
        selectedItem = uiState.selectedSport,
        onClickCard = { viewModel.onClickCard(it) },
        onDismissModal = { viewModel.onDismissModal() },
        titleRes = R.string.deportes_title,
        descriptionRes = R.string.descripcion_sport,
        topBarTitleRes = R.string.deportes_title_topbar,
        onBackButtonClicked = { onBackButtonClicked() },
        currentDestination = AppDestination.SPORTS,
        onClickNavigation = { onClickNavigation(it.label) }
    )
}