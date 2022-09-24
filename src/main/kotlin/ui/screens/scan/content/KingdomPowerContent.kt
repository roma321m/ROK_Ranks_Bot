package ui.screens.scan.content

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun KingdomPowerContent(
    onStartClick: () -> Unit,
    onAbortClick: () -> Unit
) {
    Column {
        Text("KingdomPowerContent")
        MutualContent(onStartClick = onStartClick, onAbortClick = onAbortClick)
    }
}