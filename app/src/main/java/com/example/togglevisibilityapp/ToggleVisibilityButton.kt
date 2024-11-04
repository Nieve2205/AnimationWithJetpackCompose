package com.example.togglevisibilityapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ToggleVisibilityButton() {
    var isVisible by remember { mutableStateOf(false) }
    var isBlue by remember { mutableStateOf(true) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = if (isVisible) "Ocultar" else "Mostrar")
        }

        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            val color by animateColorAsState(
                targetValue = if (isBlue) Color.Blue else Color.Green,
                animationSpec = tween(durationMillis = 500)
            )

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color)
            )
        }

        Button(onClick = { isBlue = !isBlue }) {
            Text(text = if (isBlue) "Cambiar a Verde" else "Cambiar a Azul")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewToggleVisibilityButton() {
    ToggleVisibilityButton()
}
