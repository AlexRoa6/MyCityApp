package com.example.p4_madrid_marcos_jorge_alejandro.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.p4_madrid_marcos_jorge_alejandro.model.Site
import com.example.p4_madrid_marcos_jorge_alejandro.ui.views.AppDestination

@Composable
fun <T : Site> GenericScreenContent(
    items: List<T>,
    selectedItem: T?,
    onClickCard: (T) -> Unit,
    onDismissModal: () -> Unit,
    titleRes: Int,
    descriptionRes: Int,
    topBarTitleRes: Int
) {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestination.HOME) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(topBarTitleRes) },
        bottomBar = { CustomBottomBar(currentDestination) { currentDestination = it } }
    ) { paddingValues ->

        if (selectedItem != null) {
            ModalInfo(onDismissModal = onDismissModal, site = selectedItem)
        }

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 150.dp),
            contentPadding = PaddingValues(
                start = 4.dp,
                end = 4.dp,
                top = paddingValues.calculateTopPadding() + 16.dp,
                bottom = paddingValues.calculateBottomPadding()
            )
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                TitleCategory(titleRes, descriptionRes)
            }
            items(items) { item ->
                SiteCard(site = item, onClick = { onClickCard(item) })
            }
        }
    }
}
