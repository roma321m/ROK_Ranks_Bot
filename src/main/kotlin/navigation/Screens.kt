package navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import util.Constants.HOME_SCREEN
import util.Constants.SETTINGS_SCREEN

enum class Screens(
    val label: String,
    val icon: ImageVector
) {
    HomeScreen(
        label = HOME_SCREEN,
        icon = Icons.Filled.Home
    ),
    SettingsScreen(
        label = SETTINGS_SCREEN,
        icon = Icons.Filled.Settings
    )
}