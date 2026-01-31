package com.example.p4_madrid_marcos_jorge_alejandro.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.p4_madrid_marcos_jorge_alejandro.ui.theme.Shapes
import com.example.p4_madrid_marcos_jorge_alejandro.ui.views.AppDestination

@Composable
fun CustomBottomBar(currentDestination: AppDestination, onDestinationSelected: (AppDestination) -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 8.dp)
                .border(0.5.dp, color = MaterialTheme.colorScheme.scrim, Shapes.extraLarge)
                .clip(Shapes.extraLarge)
                .background(MaterialTheme.colorScheme.background),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AppDestination.entries.forEach { destination ->
                ItemNav(destination, destination == currentDestination, { onDestinationSelected(destination) })
            }
        }
    }
}

@Composable
fun ItemNav(destination: AppDestination, isSelected: Boolean, onClick: () -> Unit) {
    val backGroundColor = if (!isSelected) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.primary
    val color = if (!isSelected) MaterialTheme.colorScheme.secondary else Color.White
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(Shapes.large)
            .background(backGroundColor)
            .clickable(onClick = onClick)
            .padding(vertical = 10.dp, horizontal = 16.dp)
    ) {
        Icon(
            painter = painterResource(destination.icon),
            contentDescription = null,
            tint = color
        )
        Text(text = destination.label, color = color)
    }
}
