package com.example.p4_madrid_marcos_jorge_alejandro.data

import com.example.p4_madrid_marcos_jorge_alejandro.model.ShopingCenter

class ShopingCenterRepository {

    fun onCLickCard(shopingCenter: ShopingCenter){
        shopingCenter.isExpanded = !shopingCenter.isExpanded
    }
}