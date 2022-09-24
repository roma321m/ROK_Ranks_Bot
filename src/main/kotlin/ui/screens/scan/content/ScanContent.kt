package ui.screens.scan.content

import androidx.compose.runtime.Composable
import ui.util.ScanAppBarState

@Composable
fun ScanContent(
    scanAppBarState: ScanAppBarState,
    onStartKingdomPowerClick: () -> Unit,
    onStartPlayerStatsClick: () -> Unit,
    onStartKingdomKillPointsClick: () -> Unit,
    onAbortKingdomPowerClick: () -> Unit,
    onAbortPlayerStatsClick: () -> Unit,
    onAbortKingdomKillPointsClick: () -> Unit,
) {
    when (scanAppBarState) {
        ScanAppBarState.KINGDOM_POWER -> {
            KingdomPowerContent(
                onStartClick = onStartKingdomPowerClick,
                onAbortClick = onAbortKingdomPowerClick
            )
        }

        ScanAppBarState.PLAYER_STATS -> {
            PlayerStatsContent(
                onStartClick = onStartPlayerStatsClick,
                onAbortClick = onAbortPlayerStatsClick
            )
        }

        ScanAppBarState.KINGDOM_KILL_POINTS -> {
            KingdomKillPointsContent(
                onStartClick = onStartKingdomKillPointsClick,
                onAbortClick = onAbortKingdomKillPointsClick
            )
        }
    }
}
