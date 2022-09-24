package ui.screens.scan.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString

@Composable
fun TabItem(
    modifier: Modifier = Modifier,
    textColor: Color,
    backgroundColor: Color,
    sliderColor: Color,
    text: String,
    onClicked: () -> Unit
) {
    Column(
        modifier = modifier
            .background(backgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ClickableText(
            text = AnnotatedString(text = text),
            onClick = { onClicked }
        )
    }
}