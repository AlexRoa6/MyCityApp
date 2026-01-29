package com.example.p4_madrid_marcos_jorge_alejandro.ui.views

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.p4_madrid_marcos_jorge_alejandro.ui.theme.P4_Madrid_Marcos_Jorge_AlejandroTheme
import com.example.p4_madrid_marcos_jorge_alejandro.viewModels.ShopingCenterViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_madrid_marcos_jorge_alejandro.R
import com.example.p4_madrid_marcos_jorge_alejandro.ui.theme.CardBackgroundDark
import com.example.p4_madrid_marcos_jorge_alejandro.ui.theme.Shapes

@Composable
fun ShopingCenterView(viewModel: ShopingCenterViewModel = viewModel()){
    val uiState by viewModel.uiState.collectAsState()
    var currentDestination by rememberSaveable { mutableStateOf(AppDestination.HOME) }


    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestination.entries.forEach {
                item(
                    icon = {
                        Icon(
                            it.icon,
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            LazyColumn (Modifier.padding(innerPadding)){

            }
        }
    }
}

@Composable
fun ShopingCard(onClickCard: () -> Unit, modifier: Modifier = Modifier) {
    Column(Modifier
        .fillMaxWidth(0.5f)){
        ShopingCenterImage()
        Spacer(Modifier.height(8.dp))
        ShopingCenterTitle()
    }


}

@Composable
fun ShopingCenterTitle() {
    Text(
        text = "Centro prueba"
    )
}

@Composable
fun ShopingCenterImage(modifier: Modifier = Modifier) {
    Box(Modifier.clip(Shapes.large)){
        Image(
            painter = painterResource(R.drawable.granplaza2),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.85f)
        )
    }
}

@Preview
@Composable
fun ShopingCenterPreview(){
    ShopingCard({})
}