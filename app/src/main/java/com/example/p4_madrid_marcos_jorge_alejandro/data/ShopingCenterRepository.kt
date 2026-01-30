package com.example.p4_madrid_marcos_jorge_alejandro.data

import com.example.p4_madrid_marcos_jorge_alejandro.R
import com.example.p4_madrid_marcos_jorge_alejandro.model.ShopingCenter

class ShopingCenterRepository {

    //Lista con todos los datos
    private val _listShopingCenters: List<ShopingCenter> = listOf(
        ShopingCenter(
            nameRes = R.string.gran_plaza,
            imgRes = R.drawable.granplaza2,
            descriptionRes = R.string.gran_plaza_desc
        ),
        ShopingCenter(
            nameRes = R.string.la_vaguada,
            imgRes = R.drawable.granplaza2,
            descriptionRes = R.string.la_vaguada_desc
        ),
        ShopingCenter(
            nameRes = R.string.xanadu,
            imgRes = R.drawable.granplaza2,
            descriptionRes = R.string.xanadu_desc
        ),
        ShopingCenter(
            nameRes = R.string.el_corte_ingles,
            imgRes = R.drawable.granplaza2,
            descriptionRes = R.string.el_corte_ingles_desc
        ),
        ShopingCenter(
            nameRes = R.string.parquesur,
            imgRes = R.drawable.granplaza2,
            descriptionRes = R.string.parquesur_desc
        ),
        ShopingCenter(
            nameRes = R.string.plenilunio,
            imgRes = R.drawable.granplaza2,
            descriptionRes = R.string.plenilunio_desc
        ),
        ShopingCenter(
            nameRes = R.string.la_gavia,
            imgRes = R.drawable.granplaza2,
            descriptionRes = R.string.la_gavia_desc
        ),
        ShopingCenter(
            nameRes = R.string.plaza_norte,
            imgRes = R.drawable.granplaza2,
            descriptionRes = R.string.plaza_norte_desc
        ),
        ShopingCenter(
            nameRes = R.string.tres_aguas,
            imgRes = R.drawable.granplaza2,
            descriptionRes = R.string.tres_aguas_desc
        ),
        ShopingCenter(
            nameRes = R.string.islazul,
            imgRes = R.drawable.granplaza2,
            descriptionRes = R.string.islazul_desc
        ),
        ShopingCenter(
            nameRes = R.string.plaza_rio,
            imgRes = R.drawable.granplaza2,
            descriptionRes = R.string.plaza_rio_desc
        ),
        ShopingCenter(
            nameRes = R.string.abc_serrano,
            imgRes = R.drawable.granplaza2,
            descriptionRes = R.string.abc_serrano_desc
        ),
        ShopingCenter(
            nameRes = R.string.el_jardin_serrano,
            imgRes = R.drawable.granplaza2,
            descriptionRes = R.string.el_jardin_serrano_desc
        ),
        ShopingCenter(
            nameRes = R.string.sexta_avenida,
            imgRes = R.drawable.granplaza2,
            descriptionRes = R.string.sexta_avenida_desc
        )
    )

    fun getShopingCenters(): List<ShopingCenter>{
        return _listShopingCenters
    }
}