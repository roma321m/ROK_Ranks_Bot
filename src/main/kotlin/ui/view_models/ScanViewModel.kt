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

    var isNameChecked by mutableStateOf(true)
        private set

    fun updateNameChecked() {
        isNameChecked = !isNameChecked
    }

    var isPowerChecked by mutableStateOf(true)
        private set

    fun updatePowerChecked() {
        isPowerChecked = !isPowerChecked
    }

    var isDeadTroopsChecked by mutableStateOf(true)
        private set

    fun updateDeadTroopsChecked() {
        isDeadTroopsChecked = !isDeadTroopsChecked
    }

    var isIdChecked by mutableStateOf(true)
        private set

    fun updateIdChecked() {
        isIdChecked = !isIdChecked
    }

    var isT1Checked by mutableStateOf(false)
        private set

    fun updateT1Checked() {
        isT1Checked = !isT1Checked
    }


    var isT2Checked by mutableStateOf(false)
        private set

    fun updateT2Checked() {
        isT2Checked = !isT2Checked
    }


    var isT3Checked by mutableStateOf(false)
        private set

    fun updateT3Checked() {
        isT3Checked = !isT3Checked
    }


    var isT4Checked by mutableStateOf(true)
        private set

    fun updateT4Checked() {
        isT4Checked = !isT4Checked
    }


    var isT5Checked by mutableStateOf(true)
        private set

    fun updateT5Checked() {
        isT5Checked = !isT5Checked
    }

    var isRSSAssistantsChecked by mutableStateOf(false)
        private set

    fun updateRSSAssistantsChecked() {
        isRSSAssistantsChecked = !isRSSAssistantsChecked
    }

    var isRSSGatheredChecked by mutableStateOf(false)
        private set

    fun updateRSSGatheredChecked() {
        isRSSGatheredChecked = !isRSSGatheredChecked
    }

    var isAllianceHelpsChecked by mutableStateOf(false)
        private set

    fun updateAllianceHelpsChecked() {
        isAllianceHelpsChecked = !isAllianceHelpsChecked
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