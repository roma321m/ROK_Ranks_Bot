package ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf

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

fun stringResourcesEnglish() = StringResources(
    appName = "ROK Ranks Bot",
    homeScreen = "Home",
    settingsScreen = "Settings",
    scanScreen = "Scan",
    infoScreen = "Info",
    start = "Start",
    abort = "Abort",
    playerStatsContentTitle = "Select stats to collect",
    playerStatsContentId = "Gov ID",
    playerStatsContentName = "Name",
    playerStatsContentPower = "Power",
    playerStatsContentDead = "Dead Troops",
    playerStatsContentT1 = "T1 Kills",
    playerStatsContentT2 = "T2 Kills",
    playerStatsContentT3 = "T3 Kills",
    playerStatsContentT4 = "T4 Kills",
    playerStatsContentT5 = "T5 Kills",
    playerStatsContentRSSA = "RSS Assistants",
    playerStatsContentRSSG = "RSS Gathered",
    playerStatsContentHelps = "Alliance Helps"
)

fun stringResourcesHebrew() = StringResources(
    appName = "בוט לדירוגים ברוק",
    homeScreen = "בית",
    settingsScreen = "הגדרות",
    scanScreen = "סריקה",
    infoScreen = "מידע",
    start = "התחלה",
    abort = "ביטול",
    playerStatsContentTitle = "Select stats to collect",
    playerStatsContentId = "מספר מזהה",
    playerStatsContentName = "שם",
    playerStatsContentPower = "עוצמה",
    playerStatsContentDead = "חיילים מתים",
    playerStatsContentT1 = "הריגות דרגה 1",
    playerStatsContentT2 = "הריגות דרגה 2",
    playerStatsContentT3 = "הריגות דרגה 3",
    playerStatsContentT4 = "הריגות דרגה 4",
    playerStatsContentT5 = "הריגות דרגה 5",
    playerStatsContentRSSA = "משאבים ששותפו",
    playerStatsContentRSSG = "משאבים שנאספו",
    playerStatsContentHelps = "עזרות לברית"
)

val LocalStringResources = compositionLocalOf { stringResourcesEnglish() }

val MaterialTheme.stringResources: StringResources
    @Composable
    @ReadOnlyComposable
    get() = LocalStringResources.current
