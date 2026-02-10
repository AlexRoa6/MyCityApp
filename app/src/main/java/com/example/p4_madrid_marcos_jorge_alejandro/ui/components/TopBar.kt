package com.example.p4_madrid_marcos_jorge_alejandro.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.p4_madrid_marcos_jorge_alejandro.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(titleRes: Int, onBackButtonClicked: () -> Unit) {
    Column {
        CenterAlignedTopAppBar(
            title = { Text(text = stringResource(titleRes)) },
            navigationIcon = {
                Icon(
                    painter = painterResource(R.drawable.outline_arrow_back_ios_24),
                    contentDescription = null,
                    modifier = Modifier.padding(start = 16.dp).clickable(onClick = { onBackButtonClicked() }),
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
