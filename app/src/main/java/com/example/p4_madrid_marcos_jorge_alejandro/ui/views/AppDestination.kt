package com.example.p4_madrid_marcos_jorge_alejandro.ui.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.p4_madrid_marcos_jorge_alejandro.R

enum class AppDestination (
    val label: String,
    val icon: Int,
) {

    FAVORITES("Favorites", R.drawable.baseline_shopping_bag_24),
    HOME("Home", R.drawable.sharp_sports_basketball_24),
    PROFILE("Profile", R.drawable.baseline_park_24),
}