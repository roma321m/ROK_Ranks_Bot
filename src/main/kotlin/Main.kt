import androidx.compose.desktop.ui.tooling.preview.Preview
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
import ui.view_models.SharedViewModel
import util.Constants.APP_ICON
import util.Constants.APP_TITLE

fun main() = application {

    val sharedViewModel = SharedViewModel()
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
            darkTheme = if (sharedViewModel.mode == Mode.SYSTEM) isSystemInDarkTheme()
            else sharedViewModel.mode == Mode.DARK
        ) {
            Surface(
                modifier = Modifier.background(color = MaterialTheme.colors.background)
            ) {
                App(navController, sharedViewModel)
            }
        }
    }
}

@Composable
fun App(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    SetupNavigation(
        navController,
        sharedViewModel
    )
}

@Composable
@Preview
fun AppPreview() {

}
