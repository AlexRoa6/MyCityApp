package com.example.p4_madrid_marcos_jorge_alejandro.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeView(){
    Box (Modifier.fillMaxSize()){
        Text("prueba de home", modifier = Modifier.align(Alignment.Center))
    }
}