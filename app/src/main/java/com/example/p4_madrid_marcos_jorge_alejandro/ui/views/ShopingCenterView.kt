package com.example.p4_madrid_marcos_jorge_alejandro.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p4_madrid_marcos_jorge_alejandro.ui.theme.P4_Madrid_Marcos_Jorge_AlejandroTheme
import com.example.p4_madrid_marcos_jorge_alejandro.viewModels.ShopingCenterViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_madrid_marcos_jorge_alejandro.R
import com.example.p4_madrid_marcos_jorge_alejandro.model.ShopingCenter
import com.example.p4_madrid_marcos_jorge_alejandro.ui.theme.Shapes

@Composable
fun ShopingCenterView(viewModel: ShopingCenterViewModel = viewModel(factory = ShopingCenterViewModel.Factory)) {
    val uiState by viewModel.uiState.collectAsState()

    ShopingCenterContent(
        shopingCenters = uiState.shopingCenters,
        onClickCard = { viewModel.onClickCard(it) },
        uiState.shopingCenterSelected,
        onDismissModal = {viewModel.onDismissModal()}
    )
}
@Composable
fun ShopingCenterContent(
    shopingCenters: List<ShopingCenter>,
    onClickCard: (ShopingCenter) -> Unit,
    selectedShopingCenter: ShopingCenter?,
    onDismissModal: () -> Unit
){

    var currentDestination by rememberSaveable { mutableStateOf(AppDestination.HOME) }


        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopBar() },
            bottomBar = { CustomBotomBar(currentDestination, { currentDestination = it })}
        ) { paddingValues ->

            if (selectedShopingCenter != null) {
                ModalInfo(onDismissModal = onDismissModal, shopingCenter = selectedShopingCenter)
            }
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = (150.dp)),
                    contentPadding = PaddingValues(
                        start = 4.dp,
                        end = 4.dp,
                        top = paddingValues.calculateTopPadding() + 16.dp,
                        bottom = paddingValues.calculateBottomPadding()
                    )
                ){

                    item (span = { GridItemSpan(maxLineSpan) }){ TitleCategory() }
                    items(shopingCenters) { shopingCenter ->
                        ShopingCard(shopingCenter, { onClickCard(shopingCenter) })
                    }
                }

            }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    Column {
        CenterAlignedTopAppBar(
            title = { Text(text = stringResource(R.string.centros_comerciales_topBar)) },
            navigationIcon = {
                Icon(
                    painter = painterResource(R.drawable.outline_arrow_back_ios_24),
                    contentDescription = null,
                    modifier = Modifier.padding(start = 16.dp)
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)

        )
        HorizontalDivider(
            thickness = 1.dp,
            color = Color.Gray.copy(alpha = 0.1f)
        )
    }
}

@Composable
fun ShopingCard(shopingCenter: ShopingCenter, onClickCard: (ShopingCenter) -> Unit, modifier: Modifier = Modifier) {
    Column(Modifier
        .fillMaxWidth(0.5f)
        .padding(12.dp)
        .clickable(onClick = { onClickCard(shopingCenter) }),
        horizontalAlignment = Alignment.CenterHorizontally){
        ShopingCenterImage(shopingCenter)
        Spacer(Modifier.height(8.dp))
        ShopingCenterTitle(shopingCenter)
    }
}

@Composable
fun ShopingCenterTitle(shopingCenter: ShopingCenter) {
    Text(
        text = stringResource(shopingCenter.nameRes),
        color = MaterialTheme.colorScheme.tertiary,
        style = MaterialTheme.typography.titleSmall
    )
}

@Composable
fun ShopingCenterImage(shopingCenter: ShopingCenter, modifier: Modifier = Modifier) {
    Box(Modifier.clip(Shapes.large)){
        Image(
            painter = painterResource(shopingCenter.imgRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.80f)
        )
    }
}

@Composable
fun TitleCategory(modifier: Modifier = Modifier) {
    Column (Modifier.padding(start = 16.dp, end = 20.dp, top = 8.dp, bottom = 8.dp)){
        Text(
            text = stringResource(R.string.title_centros_comerciales),
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.centros_comerciales_description),
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.bodyLarge,

        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalInfo(onDismissModal: () -> Unit, shopingCenter: ShopingCenter){
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var fontSize by remember { mutableStateOf(14.sp) }
    ModalBottomSheet(
        {onDismissModal()},
        sheetState =  sheetState,
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Column (){
            Image(
                painter = painterResource(shopingCenter.imgRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .clip(Shapes.extraLarge),
                contentScale = ContentScale.Crop,

            )
            Spacer(Modifier.height(24.dp))
            Text(
                text = stringResource(shopingCenter.nameRes),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.padding(top = 12.dp, start = 16.dp, bottom = 8.dp)
            )
            Text(
                text = stringResource(shopingCenter.descriptionRes),
                modifier = Modifier.padding(start = 16.dp, bottom = 32.dp, end = 16.dp),
                color = MaterialTheme.colorScheme.tertiary,
                maxLines = 8,
                onTextLayout = { layoutResult ->
                    if (layoutResult.hasVisualOverflow) {
                        fontSize = (fontSize.value * 0.9f).sp
                    }
                }
            )

            Button({}, Modifier
                .fillMaxWidth()
                .padding(end = 16.dp, start = 16.dp, bottom = 28.dp)) {
                Text(
                    text = stringResource(R.string.ver_ubicacion_buton),
                    color = MaterialTheme.colorScheme.tertiary,
                )
            }

        }
    }

}

@Composable
fun CustomBotomBar(currentDestination: AppDestination, onDestinationSelected: (AppDestination) -> Unit){
    Box(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Row(
            Modifier.fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 8.dp)
                .border(0.5.dp, color = MaterialTheme.colorScheme.scrim, Shapes.extraLarge)
                .clip(Shapes.extraLarge)
                .background(MaterialTheme.colorScheme.background),

            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            AppDestination.entries.forEach { destination ->
                ItemNav(destination, destination == currentDestination, {onDestinationSelected(destination)})
            }
        }
    }
}

@Composable
fun ItemNav(destination: AppDestination, isSelected: Boolean, onClick: () -> Unit) {
    val backGroundColor = if (!isSelected) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.primary
    val color = if (!isSelected) MaterialTheme.colorScheme.secondary else Color.White
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(Shapes.large)
            .background(backGroundColor )
            .clickable(onClick = onClick)
            .padding(vertical = 10.dp, horizontal = 16.dp)
    ){
        Icon(
            painter = painterResource(
                destination.icon),
            contentDescription = null,
            tint = color
        )
        Text(text = destination.label, color = color)
    }
}

@Preview
@Composable
fun BotomBarPreview(){
    P4_Madrid_Marcos_Jorge_AlejandroTheme {
        CustomBotomBar(AppDestination.HOME, {})
    }
}

//@Preview
//@Composable
//fun ModalPreview(){
//    P4_Madrid_Marcos_Jorge_AlejandroTheme {
//        ModalInfo({}, ShopingCenter(
//            nameRes = R.string.plaza_norte,
//            imgRes = R.drawable.granplaza2,
//            descriptionRes = R.string.plaza_norte_desc
//        ))
//    }
//}


//@Preview(showBackground = true, )
//@Composable
//fun ShopingCenterPreview(){
//    P4_Madrid_Marcos_Jorge_AlejandroTheme {
//        ShopingCenterContent(
//            shopingCenters = listOf(
//                ShopingCenter(
//                    nameRes = R.string.gran_plaza,
//                    imgRes = R.drawable.granplaza2,
//                    descriptionRes = R.string.gran_plaza_desc
//                ),
//                ShopingCenter(
//                    nameRes = R.string.la_vaguada,
//                    imgRes = R.drawable.granplaza2,
//                    descriptionRes = R.string.la_vaguada_desc
//                ),
//                ShopingCenter(
//                    nameRes = R.string.gran_plaza,
//                    imgRes = R.drawable.granplaza2,
//                    descriptionRes = R.string.gran_plaza_desc
//                ),
//                ShopingCenter(
//                    nameRes = R.string.la_vaguada,
//                    imgRes = R.drawable.granplaza2,
//                    descriptionRes = R.string.la_vaguada_desc
//                ),
//                ShopingCenter(
//                    nameRes = R.string.gran_plaza,
//                    imgRes = R.drawable.granplaza2,
//                    descriptionRes = R.string.gran_plaza_desc
//                ),
//                ShopingCenter(
//                    nameRes = R.string.la_vaguada,
//                    imgRes = R.drawable.granplaza2,
//                    descriptionRes = R.string.la_vaguada_desc
//                )
//            ),
//            onClickCard = {}
//        )
//    }
//}