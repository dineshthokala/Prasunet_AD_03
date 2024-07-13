package com.time.stopwatch.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = ButtonBackground,
    primaryVariant = ButtonBackground,
    secondary = ButtonIcons,
    background = Background,
    surface = Background,
    onPrimary = ButtonIcons,
    onSecondary = Background,
    onBackground = ButtonIcons,
    onSurface = ButtonBackground
)

private val LightColorPalette = lightColors(
    primary = ButtonIcons,
    primaryVariant = ButtonIcons,
    secondary = ButtonBackground,
    background = Background,
    surface = Background,
    onPrimary = Text,
    onSecondary = ButtonIcons,
    onBackground = Text,
    onSurface = ButtonIcons
)

@Composable
fun StopwatchTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
