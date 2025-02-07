package com.example.ebs.ui.starter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ebs.ui.components.composes.InputSpace
import com.example.ebs.utils.getGredien

@Composable
fun SignUpScreen(
    onNavigateMenu: () -> Unit,
    onNavigateLogin: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = "Buat Akun!",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = 30.sp
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))
        InputSpace("Nama")
        Spacer(modifier = Modifier.height(8.dp))
        InputSpace("Email")
        Spacer(modifier = Modifier.height(8.dp))
        InputSpace("No. Telepon")
        Spacer(modifier = Modifier.height(8.dp))
        InputSpace("Password")
        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(60.dp)
                .clickable (
                    onClick = { onNavigateMenu() })
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        getGredien(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary
                        )
                    )
            ){
                Text(
                    text = "Daftar",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.Center)
                )
            }
        }


        Spacer(modifier = Modifier.height(32.dp))


        val textkusus2 = buildAnnotatedString {
            append("Sudah punya akun? ")
            withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("Login")
            }
        }
        Text(
            text = textkusus2,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .clickable { onNavigateLogin() }
        )
    }
}