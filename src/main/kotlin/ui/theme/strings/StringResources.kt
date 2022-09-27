package ui.theme.strings

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.intl.Locale

@Immutable
data class StringResources(
    val appName: String = "",

    val homeScreen: String = "",
    val settingsScreen: String = "",
    val scanScreen: String = "",
    val infoScreen: String = "",

    val start: String = "",
    val abort: String = "",

    val playerStatsContentTitle: String = "",
    val playerStatsContentId: String = "",
    val playerStatsContentName: String = "",
    val playerStatsContentPower: String = "",
    val playerStatsContentDead: String = "",
    val playerStatsContentT1: String = "",
    val playerStatsContentT2: String = "",
    val playerStatsContentT3: String = "",
    val playerStatsContentT4: String = "",
    val playerStatsContentT5: String = "",
    val playerStatsContentRSSA: String = "",
    val playerStatsContentRSSG: String = "",
    val playerStatsContentHelps: String = ""
)

val LocalStringResources = compositionLocalOf {
    when (Locale.current.language) {
        "he" -> stringResourcesHebrew()
        "en" -> stringResourcesEnglish()
        else -> stringResourcesEnglish()
    }
}

val MaterialTheme.stringResources: StringResources
    @Composable
    @ReadOnlyComposable
    get() = LocalStringResources.current
