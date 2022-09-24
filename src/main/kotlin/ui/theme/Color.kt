package ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray

val primaryColor =  Color(0xFF4ff46b)
val primaryLightColor =  Color(0xFF8cff9c)
val primaryDarkColor =  Color(0xFF00c03b)
val primaryTextColor =  Color(0xFF000000)
val secondaryColor =  Color(0xFF8e24aa)
val secondaryLightColor =  Color(0xFFc158dc)
val secondaryDarkColor =  Color(0xFF5c007a)
val secondaryTextColor =  Color(0xFFffffff)

val LowPriorityColor = Color(0xFF00C980)
val MediumPriorityColor = Color(0xFFFFC114)
val HighPriorityColor = Color(0xFFFF4646)
val NonePriorityColor = Color(0xFFFFFFFF)

val Colors.topAppBarContentColor: Color
    @Composable
    get() = if (isLight) DarkGray else LightGray

val Colors.topAppBarBackgroundColor: Color
    @Composable
    get() = if (isLight) primaryColor else primaryDarkColor