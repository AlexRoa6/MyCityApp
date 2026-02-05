package com.example.p4_madrid_marcos_jorge_alejandro.ui.utilidades

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri


fun openMap(direccion: String, context: Context){
    val intent = Intent().apply {
        action = Intent.ACTION_VIEW
        data = "geo:0,0?q=${direccion})".toUri()

    }
    context.startActivity(intent)
}