package com.example.p4_madrid_marcos_jorge_alejandro.data

import com.example.p4_madrid_marcos_jorge_alejandro.R
import com.example.p4_madrid_marcos_jorge_alejandro.model.Ocio

class OcioRepository {

    fun onClickCard(ocio : Ocio){
        ocio.isExpanded = !ocio.isExpanded
    }

    fun getOcio(): List<Ocio> {
        return listOf(

            Ocio(
                nameRes = R.string.warner,
                imgRes = R.drawable.parque_warner,
                descriptionRes = R.string.desc_Warner
            )
        )
    }
}