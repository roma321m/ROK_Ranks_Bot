package navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ui.view_models.SharedViewModel

@Composable
fun SetupNavigation(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    val screens = Screens.values().toList()
    val currentScreen by remember {
        navController.currentScreen
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        NavigationRail(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .fillMaxHeight()
        ) {
            screens.forEach { screen ->
                NavigationRailItem(
                    selected = currentScreen == screen.name,
                    icon = {
                        Icon(
                            imageVector = screen.icon,
                            contentDescription = screen.label
                        )
                    },
                    label = {
                        Text(screen.label)
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
                sharedViewModel = sharedViewModel
            )
        }
    }
}