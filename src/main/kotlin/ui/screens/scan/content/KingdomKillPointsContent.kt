package ui.screens.scan.content

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun KingdomKillPointsContent(
    onStartClick: () -> Unit,
    onAbortClick: () -> Unit
) {
    Column {
        Text("KingdomKillPointsContent")
        MutualContent(onStartClick = onStartClick, onAbortClick = onAbortClick)
    }
}