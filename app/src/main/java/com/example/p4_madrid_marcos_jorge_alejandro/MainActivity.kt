package com.example.p4_madrid_marcos_jorge_alejandro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.p4_madrid_marcos_jorge_alejandro.ui.theme.P4_Madrid_Marcos_Jorge_AlejandroTheme
import com.example.p4_madrid_marcos_jorge_alejandro.ui.views.ShopingCenterView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            P4_Madrid_Marcos_Jorge_AlejandroTheme {
                P4_Madrid_Marcos_Jorge_AlejandroApp()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun P4_Madrid_Marcos_Jorge_AlejandroApp() {
    ShopingCenterView()

}



