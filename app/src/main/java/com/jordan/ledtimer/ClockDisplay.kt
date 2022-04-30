package com.jordan.ledtimer

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun ClockDisplay() {
    var time by remember { mutableStateOf(Time.getLatest())}
    
    LaunchedEffect(true) {
        while (true) {
            time = Time.getLatest()
            delay(1000)
        }
    }

    val style = LEDMatrixStyle(
        ledShape = LEDShape.Round,
        ledWidth = 5.dp,
        ledHeight = 5.dp,
        ledSpacing = 0.dp,
        onColor = Color.Black,
        offColor = Color(0xFFEDEDED)
    )

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        // Hour
        LEDMatrixDisplay(number = time.hour / 10, style = style)
        Spacer(modifier = Modifier.height(4.dp))
        LEDMatrixDisplay(number = time.hour % 10, style = style)
        Spacer(modifier = Modifier.height(16.dp))

        // Minute
        LEDMatrixDisplay(number = time.minutes / 10, style = style)
        Spacer(modifier = Modifier.height(4.dp))
        LEDMatrixDisplay(number = time.minutes % 10, style = style)
        Spacer(modifier = Modifier.height(16.dp))

        // Second
        LEDMatrixDisplay(number = time.seconds / 10, style = style)
        Spacer(modifier = Modifier.height(4.dp))
        LEDMatrixDisplay(number = time.seconds % 10, style = style)
        Spacer(modifier = Modifier.height(16.dp))
    }
}