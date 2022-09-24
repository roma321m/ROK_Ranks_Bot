package ui.screens.scan.content

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import navigation.NavController
import ui.view_models.ScanViewModel

@Composable
fun ScanContent(
    navController: NavController,
    scanViewModel: ScanViewModel
) {
    Text(navController.currentScreen.value)
}