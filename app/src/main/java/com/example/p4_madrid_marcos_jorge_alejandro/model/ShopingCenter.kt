package com.example.p4_madrid_marcos_jorge_alejandro.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ShopingCenter (
    @StringRes val nameRes: Int,
    @DrawableRes val imgRes: Int,
    val isExpanded: Boolean = false
)