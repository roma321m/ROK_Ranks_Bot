package ui.screens.scan

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import navigation.NavController
import ui.screens.scan.app_bar.ScanAppBar
import ui.screens.scan.content.ScanContent
import ui.util.ScanAppBarState
import ui.view_models.ScanViewModel

@Composable
fun ScanScreen(
    navController: NavController,
    scanViewModel: ScanViewModel
) {

    val scanAppBarState: ScanAppBarState = scanViewModel.scanAppBarState
    val isT1Checked: Boolean = scanViewModel.isT1Checked
    val isT2Checked: Boolean = scanViewModel.isT2Checked
    val isT3Checked: Boolean = scanViewModel.isT3Checked
    val isT4Checked: Boolean = scanViewModel.isT4Checked
    val isT5Checked: Boolean = scanViewModel.isT5Checked
    // todo - add all check box stats

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                ScanAppBar(
                    onPlayerStatsClicked = { scanViewModel.updateScanAppBarState(ScanAppBarState.PLAYER_STATS) },
                    onKingdomPowerClicked = { scanViewModel.updateScanAppBarState(ScanAppBarState.KINGDOM_POWER) },
                    onKingdomKillPointsClicked = { scanViewModel.updateScanAppBarState(ScanAppBarState.KINGDOM_KILL_POINTS) }
                )
            },
            content = {
                ScanContent(
                    scanAppBarState = scanAppBarState,
                    isT1Checked = isT1Checked,
                    onT1CheckedChange = {
                          scanViewModel.updateT1Checked()
                    },
                    isT2Checked = isT2Checked,
                    onT2CheckedChange = {
                        scanViewModel.updateT2Checked()
                    },
                    isT3Checked = isT3Checked,
                    onT3CheckedChange = {
                        scanViewModel.updateT3Checked()
                    },
                    isT4Checked = isT4Checked,
                    onT4CheckedChange = {
                        scanViewModel.updateT4Checked()
                    },
                    isT5Checked = isT5Checked,
                    onT5CheckedChange = {
                        scanViewModel.updateT5Checked()
                    },
                    // todo - add all check box stats
                    onAbortKingdomKillPointsClick = {
                        scanViewModel.abortKingdomKillPoints()
                    },
                    onAbortKingdomPowerClick = {
                        scanViewModel.abortKingdomPower()
                    },
                    onAbortPlayerStatsClick = {
                        scanViewModel.abortPlayerStats()
                    },
                    onStartKingdomKillPointsClick = {
                        scanViewModel.startKingdomKillPoints()
                    },
                    onStartKingdomPowerClick = {
                        scanViewModel.startKingdomPower()
                    },
                    onStartPlayerStatsClick = {
                        scanViewModel.startPlayerStats()
                    }
                )
            })
    }
}
