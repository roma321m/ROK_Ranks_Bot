package ui.view_models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import ui.util.Mode

class SharedViewModel {

    var mode by mutableStateOf(Mode.SYSTEM)
        private set

    fun updateMode(newMode: Mode) {
        mode = newMode
    }
}