package com.example.ebs.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ebs.R

@Preview(showBackground = true)
@Composable
fun SignInScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
    ) {


        val textkusus = buildAnnotatedString {
            withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("Halo,")
            }
            append(" Teman!")
        }
        Text(
            text = textkusus,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = 30.sp
            ),
            textAlign = TextAlign.Center
        )


        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Ada sesuatu yang tidak boleh dilewatkan agar bisa eksplor lebih jauh lagi pada aplikasi ini",
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.7f)
        )


        Spacer(modifier = Modifier.height(64.dp))
        InputSpace("Username")
        Spacer(modifier = Modifier.height(8.dp))
        InputSpace("Password")
        Spacer(modifier = Modifier.height(16.dp))


        val colorStops = listOf(
            Color.Yellow,
            Color.Red,
            Color.Blue
        )
        val gredien = Brush.linearGradient(
            colors = listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.secondary),
            start = Offset(-200f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, -200f)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(60.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(gredien)
            ){
                Text(
                    text = "Login",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.Center)
                )
            }
        }


        Spacer(modifier = Modifier.height(8.dp))


        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(50.dp)
        ){
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .width(100.dp)
                    .fillMaxHeight()
            ) { HorizontalDivider(color = Color.Gray) }
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Or",
                color = Color.Gray,
                modifier = Modifier
                    .padding(bottom = 5.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .width(100.dp)
                    .fillMaxHeight()
            ) { HorizontalDivider(color = Color.Gray) }
        }


        Card(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(60.dp)
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
            ){
                Text(
                    text = "Lanjutkan dengan Google",
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(8.dp)
                )
                Image(
                    painter = painterResource(R.drawable.google),
                    contentDescription = null,
                    modifier = Modifier
                        .height(30.dp)
                )
            }
        }


        Spacer(modifier = Modifier.height(24.dp))


        val textkusus2 = buildAnnotatedString {
            append("Belum punya akun? ")
            withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("Daftar")
            }
        }
        Text(
            text = textkusus2,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun InputSpace(text: String){
    var username by rememberSaveable { mutableStateOf("") }
    TextField(
        value = username,
        onValueChange = {username = it},
        placeholder = { Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center) },
        colors = TextFieldDefaults.colors().copy(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            errorContainerColor = Color.White,
            disabledContainerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth(0.8f)
    )
}