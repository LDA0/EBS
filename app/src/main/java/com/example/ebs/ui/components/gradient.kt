package com.example.ebs.ui.components

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun getGredienButton(color1: Color, color2: Color): Brush {
    return Brush.linearGradient(
        colors = listOf(color1, color2),
        start = Offset(-100f,-100f),
        end = Offset(600f,600f),
    )
}

fun getGredienBackground(color1: Color, color2: Color): Brush {
    return Brush.linearGradient(
        colors = listOf(color1, color2),
        start = Offset(0f,-3800f),
        end = Offset(0f,1800f),
    )
}