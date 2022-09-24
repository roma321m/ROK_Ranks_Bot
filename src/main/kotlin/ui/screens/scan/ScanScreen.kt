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
            }, content = {
                ScanContent(
                    scanViewModel = scanViewModel,
                    scanAppBarState = scanAppBarState
                )
            })
    }
}
