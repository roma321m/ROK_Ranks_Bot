package ui.screens.scan.content

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import ui.theme.stringResources

@Composable
fun MutualContent(
    onStartClick: () -> Unit,
    onAbortClick: () -> Unit
) {
    Column {
        Button(
            onClick = onStartClick
        ) {
            Text(text = MaterialTheme.stringResources.start)
        }
        Button(
            onClick = onAbortClick
        ) {
            Text(text = MaterialTheme.stringResources.abort)
        }
    }
}