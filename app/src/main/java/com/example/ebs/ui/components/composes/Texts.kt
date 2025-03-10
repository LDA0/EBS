package com.example.ebs.ui.components.composes

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TextContentS(text: Any, modifier: Modifier = Modifier, mod: Boolean = false) {
    val style = MaterialTheme.typography.labelSmall.copy(
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = 10.sp
    )
    if (mod) {
        Text(
            text as AnnotatedString,
            style = style,
            letterSpacing = 0.1.sp,
            modifier = modifier
        )
    }
    else {
        Text(
            text as String,
            style = style,
            letterSpacing = 0.1.sp,
            modifier = modifier
        )
    }
}

@Composable
fun TextContentM(text: Any, modifier: Modifier = Modifier, mod: Boolean = false) {
    val style = MaterialTheme.typography.labelSmall.copy(
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = 12.sp
    )
    if (mod) {
        Text(
            text as AnnotatedString,
            style = style,
            modifier = modifier
        )
    }
    else {
        Text(
            text as String,
            style = style,
            modifier = modifier
        )
    }
}

@Composable
fun TextContentL(text: Any, modifier: Modifier = Modifier, mod: Boolean = false) {
    val style = MaterialTheme.typography.bodySmall.copy(
        color = MaterialTheme.colorScheme.onBackground,
        fontWeight = FontWeight.Bold
    )
    if (mod) {
        Text(
            text as AnnotatedString,
            style = style,
            modifier = modifier
        )
    }
    else {
        Text(
            text as String,
            style = style,
            modifier = modifier
        )
    }
}

@Composable
fun TextTitleM(text: Any, modifier: Modifier = Modifier, mod: Boolean = false){
    val style = MaterialTheme.typography.bodyLarge.copy(
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
    if (mod) {
        Text(
            text as AnnotatedString,
            style = style,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
    }
    else {
        Text(
            text as String,
            style = style,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
    }
}

@Composable
fun TextTitleL(text: Any, modifier: Modifier = Modifier, mod: Boolean = false){
    val style = MaterialTheme.typography.headlineMedium.copy(
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold
    )
    if (mod) {
        Text(
            text as AnnotatedString,
            style = style,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
    }
    else {
        Text(
            text as String,
            style = style,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
    }
}