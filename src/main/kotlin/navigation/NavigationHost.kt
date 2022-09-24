package navigation

import androidx.compose.runtime.Composable
import ui.screens.home.HomeScreen
import ui.screens.scan.ScanScreen
import ui.screens.settings.SettingsScreen
import ui.view_models.ScanViewModel
import ui.view_models.SettingsViewModel

class NavigationHost (
    val navController: NavController,
    val content: @Composable NavigationGraphBuilder.() -> Unit
) {

    @Composable
    fun Build() {
        NavigationGraphBuilder().RenderContent()
    }

    inner class NavigationGraphBuilder(
        val navController: NavController = this@NavigationHost.navController
    ) {
        @Composable
        fun RenderContent() {
            this@NavigationHost.content(this)
        }
    }
}

@Composable
fun NavigationHost.NavigationGraphBuilder.composable (
    route: String,
    content: @Composable () -> Unit
) {
    if (navController.currentScreen.value == route) {
        content()
    }
}

@Composable
fun CustomNavigationHost(
    navController: NavController,
    settingsViewModel: SettingsViewModel,
    scanViewModel: ScanViewModel
) {
    NavigationHost(navController) {
        composable(Screens.HomeScreen.name) {
            HomeScreen(
                navController = navController
            )
        }

        composable(Screens.SettingsScreen.name) {
            SettingsScreen(
                navController = navController,
                settingsViewModel = settingsViewModel
            )
        }

        composable(Screens.ScanScreen.name) {
            ScanScreen(
                navController = navController,
                scanViewModel = scanViewModel
            )
        }

    }.Build()
}