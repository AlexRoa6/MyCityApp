package com.example.p4_madrid_marcos_jorge_alejandro.data

import com.example.p4_madrid_marcos_jorge_alejandro.R
import com.example.p4_madrid_marcos_jorge_alejandro.model.ShopingCenter

class ShopingCenterRepository {

    //Lista con todos los datos
    private val _listShopingCenters: List<ShopingCenter> = listOf(
        ShopingCenter(
            nameRes = R.string.gran_plaza,
            imgRes = R.drawable.gran_plaza2,
            descriptionRes = R.string.gran_plaza_desc,
            direccionRes = R.string.direccion_gran_plaza
        ),
        ShopingCenter(
            nameRes = R.string.la_vaguada,
            imgRes = R.drawable.la_vaguada,
            descriptionRes = R.string.la_vaguada_desc,
            direccionRes = R.string.direccion_la_vaguada
        ),
        ShopingCenter(
            nameRes = R.string.xanadu,
            imgRes = R.drawable.xanadu,
            descriptionRes = R.string.xanadu_desc,
            direccionRes = R.string.direccion_xanadu
        ),
        ShopingCenter(
            nameRes = R.string.el_corte_ingles,
            imgRes = R.drawable.corte_ingles,
            descriptionRes = R.string.el_corte_ingles_desc,
            direccionRes = R.string.direccion_el_corte_ingles
        ),
        ShopingCenter(
            nameRes = R.string.parquesur,
            imgRes = R.drawable.westfield,
            descriptionRes = R.string.parquesur_desc,
            direccionRes = R.string.direccion_parquesur
        ),
        ShopingCenter(
            nameRes = R.string.plenilunio,
            imgRes = R.drawable.plenilunio,
            descriptionRes = R.string.plenilunio_desc,
            direccionRes = R.string.direccion_plenilunio
        ),
        ShopingCenter(
            nameRes = R.string.la_gavia,
            imgRes = R.drawable.la_gavia,
            descriptionRes = R.string.la_gavia_desc,
            direccionRes = R.string.direccion_la_gavia
        ),
        ShopingCenter(
            nameRes = R.string.plaza_norte,
            imgRes = R.drawable.plaza_norte,
            descriptionRes = R.string.plaza_norte_desc,
            direccionRes = R.string.direccion_plaza_norte
        ),
        ShopingCenter(
            nameRes = R.string.tres_aguas,
            imgRes = R.drawable.tres_aguas,
            descriptionRes = R.string.tres_aguas_desc,
            direccionRes = R.string.direccion_tres_aguas
        ),
        ShopingCenter(
            nameRes = R.string.islazul,
            imgRes = R.drawable.islazul,
            descriptionRes = R.string.islazul_desc,
            direccionRes = R.string.direccion_islazul
        ),
        ShopingCenter(
            nameRes = R.string.plaza_rio,
            imgRes = R.drawable.plaza_rio,
            descriptionRes = R.string.plaza_rio_desc,
            direccionRes = R.string.direccion_plaza_rio
        ),
        ShopingCenter(
            nameRes = R.string.abc_serrano,
            imgRes = R.drawable.abc_serrano,
            descriptionRes = R.string.abc_serrano_desc,
            direccionRes = R.string.direccion_abc_serrano
        ),
        ShopingCenter(
            nameRes = R.string.sexta_avenida,
            imgRes = R.drawable.sexta_avenida,
            descriptionRes = R.string.sexta_avenida_desc,
            direccionRes = R.string.direccion_sexta_avenida
        )
    )

    fun getShopingCenters(): List<ShopingCenter>{
        return _listShopingCenters
    }
}