package com.example.p4_madrid_marcos_jorge_alejandro.model

class Sport(val categoria: Categoria, nameRes: Int, imgRes: Int, descriptionRes: Int, isExpanded: Boolean):
    Site(nameRes, imgRes, descriptionRes, isExpanded ) {

}

enum class Categoria {
    FUTBOL,
    BALONCESTO,
    TENIS,
    ATLETISMO
}

