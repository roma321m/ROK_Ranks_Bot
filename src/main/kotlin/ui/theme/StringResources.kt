package ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf

@Immutable
data class StringResources(
    val appName: String = ""
)

fun stringResourcesEnglish() = StringResources(
    appName = "ROK Ranks Bot"
)

fun stringResourcesHebrew() = StringResources(
    appName = "בוט לדירוגים ברוק"
)

val LocalStringResources = compositionLocalOf { stringResourcesEnglish() }

val MaterialTheme.stringResources: StringResources
    @Composable
    @ReadOnlyComposable
    get() = LocalStringResources.current
