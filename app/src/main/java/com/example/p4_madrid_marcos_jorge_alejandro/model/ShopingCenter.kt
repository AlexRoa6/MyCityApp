package com.example.p4_madrid_marcos_jorge_alejandro.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class ShopingCenter(
    nameRes: Int,
    imgRes: Int,
    descriptionRes: Int,
    isExpanded: Boolean=false): Site(nameRes, imgRes, descriptionRes, isExpanded)
