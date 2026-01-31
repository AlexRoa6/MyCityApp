package com.example.p4_madrid_marcos_jorge_alejandro.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun TitleCategory(titleRes: Int, descriptionRes: Int, modifier: Modifier = Modifier) {
    Column(modifier.padding(start = 16.dp, end = 20.dp, top = 8.dp, bottom = 8.dp)) {
        Text(
            text = stringResource(titleRes),
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = stringResource(descriptionRes),
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}
