package com.carloszaragoza.calculatorapp.feature_calculator.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(

    background = darkBackground,
    onBackground = darkPanel,
    primary = darkNumberKey,
    secondary = darkActionKey,
    onPrimary = principal,
    primaryVariant = lightBackground
)

private val LightColorPalette = lightColors(

    background = lightBackground,
    onBackground = lightPanel,
    primary = lightNumberKey,
    secondary = lightActionKey,
    onPrimary = principal,
    primaryVariant = darkBackground
)

@Composable
fun CalculatorAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
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