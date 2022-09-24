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

    fun startPlayerStats() {
        // Todo - use command here
    }

    fun startKingdomPower() {
        // Todo - use command here
    }

    fun startKingdomKillPoints() {
        // Todo - use command here
    }

    fun abortPlayerStats() {
        // Todo - use command here
    }

    fun abortKingdomPower() {
        // Todo - use command here
    }

    fun abortKingdomKillPoints() {
        // Todo - use command here
    }
}