package com.example.ebs.ui.components.composes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ebs.ui.components.getGredienButton

@Composable
fun InputSpace(
    text: String,
    modifier: Modifier = Modifier
){
    var inpud by rememberSaveable { mutableStateOf("") }
    TextField(
        value = inpud,
        onValueChange = {inpud = it},
        placeholder = { Text(
            text = text,
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            textAlign = TextAlign.Center) },
        modifier = modifier
            .fillMaxWidth(0.8f)
            .padding(8.dp)
    )
}

@Composable
fun AestheticButton(
    text: String,
    onClick: () -> Unit
){
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(60.dp)
            .clickable (
                onClick = onClick
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(getGredienButton(
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.colorScheme.secondary
                ))
        ){
            Text(
                text = text,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Center)
            )
        }
    }
}
