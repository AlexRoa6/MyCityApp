package com.example.p4_madrid_marcos_jorge_alejandro.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p4_madrid_marcos_jorge_alejandro.R
import com.example.p4_madrid_marcos_jorge_alejandro.model.Site
import com.example.p4_madrid_marcos_jorge_alejandro.ui.theme.Shapes
import com.example.p4_madrid_marcos_jorge_alejandro.ui.utilidades.openMap

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalInfo(onDismissModal: () -> Unit, site: Site) {
    val direccion = stringResource(site.direccionRes)
    val context = LocalContext.current
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var fontSize by remember { mutableStateOf(14.sp) }
    ModalBottomSheet(
        { onDismissModal() },
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Column {
            Image(
                painter = painterResource(site.imgRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .clip(Shapes.extraLarge),
                contentScale = ContentScale.Crop,
            )
            Spacer(Modifier.height(24.dp))
            Text(
                text = stringResource(site.nameRes),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.padding(top = 12.dp, start = 16.dp, bottom = 8.dp)
            )
            Text(
                text = stringResource(site.descriptionRes),
                modifier = Modifier.padding(start = 16.dp, bottom = 32.dp, end = 16.dp),
                color = MaterialTheme.colorScheme.tertiary,
                maxLines = 8,
                onTextLayout = { layoutResult ->
                    if (layoutResult.hasVisualOverflow) {
                        fontSize = (fontSize.value * 0.9f).sp
                    }
                },
                fontSize = fontSize
            )
            Button(
                { openMap(direccion, context) },
                Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp, start = 16.dp, bottom = 28.dp)
            ) {
                Text(
                    text = stringResource(R.string.ver_ubicacion_buton),
                    color = Color.White,
                )
            }
        }
    }
}
