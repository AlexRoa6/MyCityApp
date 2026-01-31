package com.example.p4_madrid_marcos_jorge_alejandro.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_madrid_marcos_jorge_alejandro.R
import com.example.p4_madrid_marcos_jorge_alejandro.model.Ocio
import com.example.p4_madrid_marcos_jorge_alejandro.ui.components.GenericScreenContent
import com.example.p4_madrid_marcos_jorge_alejandro.viewModels.deportesViewModel
import com.example.p4_madrid_marcos_jorge_alejandro.viewModels.ocioViewModel

@Composable
fun OcioView(viewModel: ocioViewModel = viewModel()){
    val uiState by viewModel.uiState.collectAsState()

    GenericScreenContent(
        items = uiState.ocioList,
        selectedItem = uiState.selectedOcio,
        onClickCard = { viewModel.onClickCard(it) },
        onDismissModal = { viewModel.onDismissModal() },
        titleRes = R.string.ocio_title,
        descriptionRes = R.string.descripcion_ocio,
        topBarTitleRes = R.string.ocio_title_topbar
    )
}