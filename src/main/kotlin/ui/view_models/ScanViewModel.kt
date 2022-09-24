package ui.view_models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import ui.util.ScanAppBarState

class ScanViewModel {

    var scanAppBarState by mutableStateOf(ScanAppBarState.PLAYER_STATS)
        private set

    fun updateScanAppBarState(newState: ScanAppBarState) {
        scanAppBarState = newState
    }
}