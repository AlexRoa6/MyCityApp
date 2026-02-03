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
                imgRes = R.drawable.faunia_madrid,
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

            Ocio(
                nameRes = R.string.paintball_madrid,
                imgRes = R.drawable.paintball,
                descriptionRes = R.string.paintball_madrid
            ),

            Ocio(
                nameRes = R.string.kars_sainz,
                imgRes = R.drawable.carlos_sainz,
                descriptionRes = R.string.desc_kars
            ),

            Ocio(
                nameRes = R.string.pub_el_tren,
                imgRes = R.drawable.pub_tren,
                descriptionRes = R.string.desc_pub
            ),

            Ocio(
                nameRes = R.string.laser_tag,
                imgRes = R.drawable.laser_tag,
                descriptionRes = R.string.desc_laser
            ),

            Ocio(
                nameRes = R.string.tirolinas,
                imgRes = R.drawable.aventura_amazonia,
                descriptionRes = R.string.desc_tirolinas
            ),

            Ocio(
                nameRes = R.string.retiro,
                imgRes = R.drawable.retiro_madrid,
                descriptionRes = R.string.desc_retiro
            ),

            Ocio(
                nameRes = R.string.parque_europa,
                imgRes = R.drawable.parque_europa,
                descriptionRes = R.string.desc_parque_europa
            )
        )
    }
}