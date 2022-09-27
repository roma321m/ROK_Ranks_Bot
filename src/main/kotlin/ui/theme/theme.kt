package ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.intl.Locale

val DarkColorPalette = darkColors(
    primary = primaryColor,
    primaryVariant = primaryDarkColor,
    secondary = secondaryColor,
    secondaryVariant = secondaryDarkColor,
)

val LightColorPalette = lightColors(
    primary = primaryColor,
    primaryVariant = primaryLightColor,
    secondary = secondaryColor,
    secondaryVariant = secondaryLightColor,
)

@Composable
fun RokRanksBotApp(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    val stringResources = when (Locale.current.language) {
        "HE" -> stringResourcesHebrew()
        else -> stringResourcesEnglish()
    }

    CompositionLocalProvider(
        LocalSpacing provides Spacing(),
        LocalElevation provides Elevation(),
        LocalStringResources provides stringResources
    ) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}