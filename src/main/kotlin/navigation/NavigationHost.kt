package navigation

import androidx.compose.runtime.Composable
import ui.screens.home.HomeScreen
import ui.screens.settings.SettingsScreen
import ui.view_models.SharedViewModel

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
    sharedViewModel: SharedViewModel
) {
    NavigationHost(navController) {
        composable(Screens.HomeScreen.name) {
            HomeScreen(navController)
        }

        composable(Screens.SettingsScreen.name) {
            SettingsScreen(navController, sharedViewModel)
        }

    }.Build()
}