package ui.screens.scan.content

import androidx.compose.runtime.Composable
import ui.util.ScanAppBarState

@Composable
fun ScanContent(
    isT1Checked: Boolean,
    onT1CheckedChange: () -> Unit,
    isT2Checked: Boolean,
    onT2CheckedChange: () -> Unit,
    isT3Checked: Boolean,
    onT3CheckedChange: () -> Unit,
    isT4Checked: Boolean,
    onT4CheckedChange: () -> Unit,
    isT5Checked: Boolean,
    onT5CheckedChange: () -> Unit,
    // todo - add all check box stats
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
                onAbortClick = onAbortPlayerStatsClick,
                isT1Checked = isT1Checked,
                onT1CheckedChange = onT1CheckedChange,
                isT2Checked = isT2Checked,
                onT2CheckedChange = onT2CheckedChange,
                isT3Checked = isT3Checked,
                onT3CheckedChange = onT3CheckedChange,
                isT4Checked = isT4Checked,
                onT4CheckedChange = onT4CheckedChange,
                isT5Checked = isT5Checked,
                onT5CheckedChange = onT5CheckedChange,
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
