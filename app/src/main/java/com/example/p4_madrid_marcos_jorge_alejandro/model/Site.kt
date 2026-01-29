package com.example.p4_madrid_marcos_jorge_alejandro.model

import android.accessibilityservice.GestureDescription
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

open class Site (
    @StringRes val nameRes: Int,
    @DrawableRes val imgRes: Int,
    @StringRes val descriptionRes: Int
)