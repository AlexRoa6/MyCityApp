package com.example.p4_madrid_marcos_jorge_alejandro.model

class Sport(val categoria: Categoria, nameRes: Int, imgRes: Int, descriptionRes: Int, direccionRes: Int):
    Site(nameRes, imgRes, descriptionRes, direccionRes) {

}

enum class Categoria {
    FUTBOL,
    BALONCESTO,
    TENIS,
    ATLETISMO
}

