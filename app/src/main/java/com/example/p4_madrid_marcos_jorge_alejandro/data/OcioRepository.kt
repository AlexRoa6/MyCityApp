package com.example.p4_madrid_marcos_jorge_alejandro.data

import com.example.p4_madrid_marcos_jorge_alejandro.R
import com.example.p4_madrid_marcos_jorge_alejandro.model.Ocio

class OcioRepository {

    fun getOcio(): List<Ocio> {
        return listOf(

            Ocio(
                nameRes = R.string.warner,
                imgRes = R.drawable.parque_warner,
                descriptionRes = R.string.desc_Warner,
                direccionRes = R.string.direcc_warner,
            ),

            Ocio(
                nameRes = R.string.zoo_madrid,
                imgRes = R.drawable.zoo_madrid,
                descriptionRes = R.string.desc_zoo,
                direccionRes = R.string.direcc_atracciones
            ),

            Ocio(
                nameRes = R.string.parqueAtracc,
                imgRes = R.drawable.parque_atracciones,
                descriptionRes = R.string.desc_Parque,
                direccionRes = R.string.direcc_atracciones
            ),

            Ocio(
                nameRes = R.string.faunia,
                imgRes = R.drawable.faunia_madrid,
                descriptionRes = R.string.faunia_desc,
                direccionRes = R.string.direcc_faunia
            ),

            Ocio(
                nameRes = R.string.museo_prado,
                imgRes = R.drawable.museo_prado,
                descriptionRes = R.string.desc_prado,
                direccionRes = R.string.direcc_pardo
            ),

            Ocio(
                nameRes = R.string.museo_thyssen,
                imgRes = R.drawable.museo_thyssen,
                descriptionRes = R.string.desc_thyssen,
                direccionRes = R.string.direcc_thyssen
            ),

            Ocio(
                nameRes = R.string.museo_geominero,
                imgRes = R.drawable.museo_geominero,
                descriptionRes = R.string.desc_geomin,
                direccionRes = R.string.direcc_geominero
            ),

            Ocio(
                nameRes = R.string.museo_reina_sofia,
                imgRes = R.drawable.reina_sofia,
                descriptionRes = R.string.desc_sofia,
                direccionRes = R.string.direcc_sofia
            ),

            Ocio(
                nameRes = R.string.paintball_madrid,
                imgRes = R.drawable.paintball,
                descriptionRes = R.string.paintball_madrid,
                direccionRes = R.string.direcc_paintball
            ),

            Ocio(
                nameRes = R.string.kars_sainz,
                imgRes = R.drawable.carlos_sainz,
                descriptionRes = R.string.desc_kars,
                direccionRes = R.string.direcc_kars
            ),

            Ocio(
                nameRes = R.string.pub_el_tren,
                imgRes = R.drawable.pub_tren,
                descriptionRes = R.string.desc_pub,
                direccionRes = R.string.direcc_el_tren

            ),

            Ocio(
                nameRes = R.string.laser_tag,
                imgRes = R.drawable.laser_tag,
                descriptionRes = R.string.desc_laser,
                direccionRes = R.string.direcc_laser
            ),

            Ocio(
                nameRes = R.string.tirolinas,
                imgRes = R.drawable.aventura_amazonia,
                descriptionRes = R.string.desc_tirolinas,
                direccionRes = R.string.direcc_tirolinas
            ),

            Ocio(
                nameRes = R.string.retiro,
                imgRes = R.drawable.retiro_madrid,
                descriptionRes = R.string.desc_retiro,
                direccionRes = R.string.direcc_retiro
            ),

            Ocio(
                nameRes = R.string.parque_europa,
                imgRes = R.drawable.parque_europa,
                descriptionRes = R.string.desc_parque_europa,
                direccionRes = R.string.direcc_parque_europa
            )
        )
    }
}