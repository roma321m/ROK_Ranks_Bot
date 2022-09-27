package navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ui.theme.strings.stringResources
import ui.view_models.ScanViewModel
import ui.view_models.SettingsViewModel
import util.Constants.HOME_SCREEN
import util.Constants.INFO_SCREEN
import util.Constants.SCAN_SCREEN
import util.Constants.SETTINGS_SCREEN

@Composable
fun SetupNavigation(
    navController: NavController,
    settingsViewModel: SettingsViewModel,
    scanViewModel: ScanViewModel
) {
    val screens = Screens.values().toList()
    val currentScreen by remember {
        navController.currentScreen
    }

    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        NavigationRail(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxHeight()
        ) {
            screens.forEach { screen ->
                val label = when (screen.label) {
                    HOME_SCREEN -> {
                        MaterialTheme.stringResources.homeScreen
                    }

                    SETTINGS_SCREEN -> {
                        MaterialTheme.stringResources.settingsScreen
                    }

                    SCAN_SCREEN -> {
                        MaterialTheme.stringResources.scanScreen
                    }

                    INFO_SCREEN -> {
                        MaterialTheme.stringResources.infoScreen
                    }

                    else -> {
                        ""
                    }
                }

                NavigationRailItem(
                    selected = currentScreen == screen.name,
                    icon = {
                        Icon(
                            imageVector = screen.icon,
                            contentDescription = label
                        )
                    },
                    label = {
                        Text(label)
                    },
                    alwaysShowLabel = false,
                    onClick = {
                        navController.navigate(screen.name)
                    }
                )
            }

        }

        Box(
            modifier = Modifier.fillMaxHeight()
        ) {
            CustomNavigationHost(
                navController = navController,
                settingsViewModel = settingsViewModel,
                scanViewModel = scanViewModel
            )
        }
    }
}