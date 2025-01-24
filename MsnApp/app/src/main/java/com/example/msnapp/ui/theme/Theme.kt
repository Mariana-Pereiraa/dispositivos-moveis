package com.example.msnapp.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF38389F),
    onPrimary = Color.White,
    secondary = Color(0xFF37768A),
    onSecondary = Color.Black,
    surface = Color(0xFF409D80),
    onSurface = Color.Black,
    background = Color(0xFFF5F5F5),
    onBackground = Color.Black
)

@Composable
fun MsnAppTheme(
    darkTheme: Boolean = false, // Você pode implementar controle de tema dinâmico
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
}
