package com.example.p4_madrid_marcos_jorge_alejandro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.p4_madrid_marcos_jorge_alejandro.ui.theme.P4_Madrid_Marcos_Jorge_AlejandroTheme
import com.example.p4_madrid_marcos_jorge_alejandro.ui.views.AppDestination
import com.example.p4_madrid_marcos_jorge_alejandro.ui.views.HomeView
import com.example.p4_madrid_marcos_jorge_alejandro.ui.views.OcioView
import com.example.p4_madrid_marcos_jorge_alejandro.ui.views.ShopingCenterView
import com.example.p4_madrid_marcos_jorge_alejandro.ui.views.SportsView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            P4_Madrid_Marcos_Jorge_AlejandroTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppDestination.HOME.label,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {

        composable(route = AppDestination.HOME.label) {
            HomeView(
                navigateShoping = { navController.navigate(AppDestination.SHOPING_CENTER.label)},
                navigateOcio = { navController.navigate(AppDestination.OCIO.label) },
                navigateSport = { navController.navigate(AppDestination.SPORTS.label) },
                onClickNavigation = { navController.navigate(it) }
            )
        }

        composable(route = AppDestination.SHOPING_CENTER.label) {
            ShopingCenterView(
                onBackButtonClicked = { navController.navigate(AppDestination.HOME.label) },
                onClickNavigation = { navController.navigate(it) }
            )
        }

        composable(route = AppDestination.OCIO.label) {
            OcioView(
                onBackButtonClicked = { navController.navigate(AppDestination.HOME.label) },
                onClickNavigation = { navController.navigate(it) }
            )
        }

        composable(route = AppDestination.SPORTS.label) {
            SportsView(
                onBackButtonClicked = { navController.navigate(AppDestination.HOME.label) },
                onClickNavigation = { navController.navigate(it) }
            )
        }
    }
}

@PreviewScreenSizes
@Composable
fun P4_Madrid_Marcos_Jorge_AlejandroApp() {
    P4_Madrid_Marcos_Jorge_AlejandroTheme {
        AppNavigation()
    }
}