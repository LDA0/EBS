package com.example.ebs.ui.components.composes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

//Typical narcissistic composes for this app

@Composable
fun CenterColumn(
    vArr: Arrangement.Vertical = Arrangement.Center,
    hAli: Alignment.Horizontal = Alignment.CenterHorizontally,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        verticalArrangement = vArr,
        horizontalAlignment = hAli,
        modifier = modifier
    ){
        content()
    }
}

@Composable
fun CenterRow(
    hArr: Arrangement.Horizontal = Arrangement.Center,
    vAli: Alignment.Vertical = Alignment.CenterVertically,
    modifier: Modifier =  Modifier,
    content: @Composable () -> Unit
) {
    Row(
        horizontalArrangement = hArr,
        verticalAlignment = vAli,
        modifier = modifier
    ){
        content()
    }
}