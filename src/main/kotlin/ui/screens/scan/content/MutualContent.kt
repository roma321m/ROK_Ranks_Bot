package ui.screens.scan.content

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun MutualContent(
    onStartClick: () -> Unit,
    onAbortClick: () -> Unit
) {
    Column {
        Button(
            onClick = onStartClick
        ) {
            Text("Start")
        }
        Button(
            onClick = onAbortClick
        ) {
            Text("Abort")
        }
    }
}