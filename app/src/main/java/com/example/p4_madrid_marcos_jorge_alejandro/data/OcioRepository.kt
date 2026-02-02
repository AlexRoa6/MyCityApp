package com.example.p4_madrid_marcos_jorge_alejandro.data

import com.example.p4_madrid_marcos_jorge_alejandro.R
import com.example.p4_madrid_marcos_jorge_alejandro.model.Ocio

class OcioRepository {

    fun getOcio(): List<Ocio> {
        return listOf(

            Ocio(
                nameRes = R.string.warner,
                imgRes = R.drawable.parque_warner,
                descriptionRes = R.string.desc_Warner
            ),

            Ocio(
                nameRes = R.string.parqueAtracc,
                imgRes = R.drawable.parque_atracciones,
                descriptionRes = R.string.desc_Parque
            ),

            Ocio(
                nameRes = R.string.faunia_madrid,
                imgRes = R.drawable.parque_atracciones,
                descriptionRes = R.string.desc_faunia
            ),

            Ocio(
                nameRes = R.string.museo_prado,
                imgRes = R.drawable.museo_prado,
                descriptionRes = R.string.desc_prado
            ),

            Ocio(
                nameRes = R.string.museo_thyssen,
                imgRes = R.drawable.museo_thyssen,
                descriptionRes = R.string.desc_thyssen
            ),

            Ocio(
                nameRes = R.string.museo_geominero,
                imgRes = R.drawable.museo_geominero,
                descriptionRes = R.string.desc_geomin
            ),

            Ocio(
                nameRes = R.string.museo_reina_sofia,
                imgRes = R.drawable.reina_sofia,
                descriptionRes = R.string.desc_sofia
            ),
        )
    }
}