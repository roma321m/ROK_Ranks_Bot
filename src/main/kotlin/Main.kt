import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import navigation.*
import ui.theme.RokRanksBotApp
import ui.theme.WINDOW_HEIGHT
import ui.theme.WINDOW_WIDTH
import ui.util.Mode
import ui.view_models.ScanViewModel
import ui.view_models.SettingsViewModel
import util.Constants.APP_ICON
import util.Constants.APP_TITLE

fun main() = application {

    val settingsViewModel = SettingsViewModel()
    val scanViewModel = ScanViewModel()
    val navController by rememberNavController(Screens.HomeScreen.name)

    Window(
        resizable = false,
        onCloseRequest = ::exitApplication,
        title = APP_TITLE,
        icon = painterResource(APP_ICON),
        state = rememberWindowState(
            width = WINDOW_WIDTH,
            height = WINDOW_HEIGHT,
        )
    ) {
        RokRanksBotApp(
            darkTheme = if (settingsViewModel.mode == Mode.SYSTEM) isSystemInDarkTheme()
            else settingsViewModel.mode == Mode.DARK
        ) {
            Surface(
                modifier = Modifier.background(color = MaterialTheme.colors.background)
            ) {
                App(
                    navController = navController,
                    settingsViewModel = settingsViewModel,
                    scanViewModel = scanViewModel
                )
            }
        }
    }
}

@Composable
fun App(
    navController: NavController,
    settingsViewModel: SettingsViewModel,
    scanViewModel: ScanViewModel
) {
    SetupNavigation(
        navController,
        settingsViewModel,
        scanViewModel
    )
}
