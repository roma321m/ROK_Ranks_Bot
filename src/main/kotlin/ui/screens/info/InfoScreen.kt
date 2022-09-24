package ui.screens.info

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import navigation.NavController

@Composable
fun InfoScreen(
    navController: NavController
) {
    Text(navController.currentScreen.value)
}