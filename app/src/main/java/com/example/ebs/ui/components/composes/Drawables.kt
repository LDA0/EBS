package com.example.ebs.ui.components.composes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeSource

@Composable
fun MyIcon(
    painter: Painter,
    contentDescription: String,
    tint: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.secondary,
    modifier: Modifier = Modifier
){
    Icon(
        painter = painter,
        contentDescription = contentDescription,
        tint = tint,
        modifier = modifier
    )
}

@Composable
fun MyIconImage(
    painter: Painter,
    contentDescription: String,
    modifier: Modifier = Modifier
){
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier
            .size(50.dp)
    )
}

@Composable
fun MyCard(
    modifier: Modifier = Modifier,
    border: BorderStroke = BorderStroke(
        width = 0.9.dp,
        MaterialTheme.colorScheme.onSurface
    ),
    content: @Composable () -> Unit
){
    Card(
        border = border,
        modifier = modifier
            .padding(vertical = 10.dp)
    ){
        content()
    }
}

@Composable
fun MyPage(
    hazeState: HazeState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    CenterColumn(
        vArr= Arrangement.Top,
        modifier = modifier
            .fillMaxSize()
            .hazeSource(hazeState)
    ){
        content()
    }
}

@Composable
fun Indicator(
    text: String,
    color: Color
){
    CenterRow(
        modifier = Modifier
            .height(20.dp)
            .clip(CircleShape)
            .background(
                color.copy(
                    alpha = 0.15f
                )
            )
    ) {
        CenterRow(
            modifier = Modifier
                .padding(horizontal = 8.dp)
        ){
            CenterRow(
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(5.dp)
                    .clip(CircleShape)
                    .background(
                        color
                    )
            ) {}
            TextContentS(buildAnnotatedString {
                withStyle(SpanStyle(color = color)) {
                    append(text)
                }
            }, mod = true)
        }
    }
}
