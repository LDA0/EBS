package com.example.ebs.utils

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun getGredien(color1: Color, color2: Color): Brush {
    return Brush.linearGradient(
        colors = listOf(color1, color2),
        start = Offset(-100f,-100f),
        end = Offset(600f,600f),
    )
}