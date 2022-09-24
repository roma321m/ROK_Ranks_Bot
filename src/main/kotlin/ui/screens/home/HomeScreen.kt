package ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import data.command.Commands
import data.command.images.TakeScreenShotCommand
import navigation.NavController
import util.Constants.IMAGE_TYPE

@Composable
fun HomeScreen(
    navController: NavController
) {
    val takeScreenShot = TakeScreenShotCommand(x = 10, y = 10, width = 500, height = 500, path = "temps/screenshot$IMAGE_TYPE", Commands())

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Todo - remove this temp text indicator
        Text(navController.currentScreen.value)

        // Todo - temp for command testing
        Button(onClick = { takeScreenShot.execute() }) {
            Text("test button")
        }
    }
}