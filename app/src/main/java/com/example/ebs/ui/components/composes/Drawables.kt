package com.example.ebs.ui.components.composes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
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
    border: BorderStroke = BorderStroke(
        width = 0.9.dp,
        MaterialTheme.colorScheme.onSurface
    ),
    modifier: Modifier = Modifier
        .padding(vertical = 10.dp),
    content: @Composable () -> Unit
){
    Card(
        border = border,
        modifier = modifier
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
            .background(MaterialTheme.colorScheme.surface)
    ){
        content()
    }
}
