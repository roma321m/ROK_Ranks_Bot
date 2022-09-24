package ui.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import navigation.NavController
import ui.util.Mode
import ui.view_models.SharedViewModel

@Composable
fun SettingsScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Todo - remove this temp text indicator
        Text(navController.currentScreen.value)

        // Todo - radio button
        Button(onClick = { sharedViewModel.updateMode(Mode.DARK) }) {
            Text("dark")
        }
        Button(onClick = { sharedViewModel.updateMode(Mode.LIGHT) }) {
            Text("light")
        }
        Button(onClick = { sharedViewModel.updateMode(Mode.SYSTEM) }) {
            Text("system")
        }
    }
}