package com.example.p4_madrid_marcos_jorge_alejandro.data

import com.example.p4_madrid_marcos_jorge_alejandro.model.ShopingCenter

class ShopingCenterRepository {

    //Lista con todos los datos
    private val _listShopingCenters: List<ShopingCenter> = listOf()
    fun onCLickCard(shopingCenter: ShopingCenter){
        shopingCenter.isExpanded = !shopingCenter.isExpanded
    }

    fun getShopingCenters(): List<ShopingCenter>{
        return _listShopingCenters
    }
}