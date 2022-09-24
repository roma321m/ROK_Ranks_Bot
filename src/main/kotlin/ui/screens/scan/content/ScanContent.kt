package ui.screens.scan.content

import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import ui.util.ScanAppBarState
import ui.view_models.ScanViewModel

@Composable
fun ScanContent(
    scanViewModel: ScanViewModel,
    scanAppBarState: ScanAppBarState
) {
    when (scanAppBarState) {
        ScanAppBarState.KINGDOM_POWER -> {
            KingdomPowerContent()
        }
        ScanAppBarState.PLAYER_STATS -> {
            PlayerStatsContent()
        }
        ScanAppBarState.KINGDOM_KILL_POINTS -> {
            KingdomKillPointsContent()
        }
    }
}

@Composable
fun KingdomPowerContent() {
    Text("KingdomPowerContent")
}

@Composable
fun KingdomKillPointsContent() {
    Text("KingdomKillPointsContent")
}

@Composable
fun PlayerStatsContent() {
    Text("PlayerStatsContent")
}