package com.example.p4_madrid_marcos_jorge_alejandro.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_madrid_marcos_jorge_alejandro.R
import com.example.p4_madrid_marcos_jorge_alejandro.model.Categoria
import com.example.p4_madrid_marcos_jorge_alejandro.model.Sport
import com.example.p4_madrid_marcos_jorge_alejandro.ui.theme.P4_Madrid_Marcos_Jorge_AlejandroTheme
import com.example.p4_madrid_marcos_jorge_alejandro.ui.theme.Shapes
import com.example.p4_madrid_marcos_jorge_alejandro.viewModels.deportesViewModel
import kotlin.collections.listOf

@Composable
fun SportsView(
    viewModel: deportesViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    SportsContent(
        uiState.deportesList
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SportsTopBar() {
    CenterAlignedTopAppBar(
        title = { Text(text = "Sports") }
    )
}

@Composable
fun SportsTitle() {
    Column(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 8.dp)
    ) {
        Text(
            text = "Recommended sports",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Discover the main sport events and places in Madrid",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun SportCard(
    sport: Sport,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(modifier = Modifier.clip(Shapes.large)) {
            Image(
                painter = painterResource(id = sport.imgRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.85f)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(id = sport.nameRes),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun SportDetailDialog(
    sport: Sport,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "Close")
            }
        },
        title = {
            Text(text = stringResource(sport.nameRes))
        },
        text = {
            Column {
                Image(
                    painter = painterResource(id = sport.imgRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(Shapes.medium)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = stringResource(sport.descriptionRes))
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun SportsPreview() {
    P4_Madrid_Marcos_Jorge_AlejandroTheme {
        SportsContent(
            sports = listOf(
                Sport(
                    categoria = Categoria.FUTBOL,
                    nameRes = R.string.Titulo_realmadrid,
                    descriptionRes = R.string.descripcion_realmadrid,
                    imgRes = R.drawable.brenabeu
                ),
                Sport(
                    categoria = Categoria.FUTBOL,
                    nameRes = R.string.titulo_atletico,
                    descriptionRes = R.string.descripcion_atleti,
                    imgRes = R.drawable.wanda
                ),
                Sport(
                    categoria = Categoria.BALONCESTO,
                    nameRes = R.string.titulo_baloncesto,
                    descriptionRes = R.string.descripcion_baloncesto,
                    imgRes = R.drawable.wizinkbasket
                ),
                Sport(
                    categoria = Categoria.ATLETISMO,
                    nameRes = R.string.maraton,
                    descriptionRes = R.string.descripcion_maraton,
                    imgRes = R.drawable.maratonmadrid
                ),
                Sport(
                    categoria = Categoria.ATLETISMO,
                    nameRes = R.string.san_silvestre,
                    descriptionRes = R.string.descripcion_sansil,
                    imgRes = R.drawable.sansilvestre
                ),
                Sport(
                    categoria = Categoria.TENIS,
                    nameRes = R.string.mutua,
                    descriptionRes = R.string.descripcion_mutua,
                    imgRes = R.drawable.mutuaopenmadrid_pista
                )
            )
        )
    }
}

@Composable
fun SportsContent(sports: List<Sport>) {
    var selectedSport by remember { mutableStateOf<Sport?>(null) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestination.entries.forEach {
                item(
                    icon = { Icon(it.icon, contentDescription = it.label) },
                    label = { Text(it.label) },
                    selected = it == AppDestination.HOME,
                    onClick = { }
                )
            }
        }
    ) {
        Scaffold(
            topBar = { SportsTopBar() }
        ) { paddingValues ->

            Column(modifier = Modifier.padding(paddingValues)) {

                SportsTitle()

                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 150.dp),
                    contentPadding = PaddingValues(8.dp)
                ) {
                    items(sports) { sport ->
                        SportCard(
                            sport = sport,
                            onClick = {  }
                        )
                    }
                }
            }
        }

        selectedSport?.let {
            SportDetailDialog(
                sport = it,
                onDismiss = { selectedSport = null }
            )
        }
    }
}