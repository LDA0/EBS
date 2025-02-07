package com.example.ebs.ui.starter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ebs.R
import com.example.ebs.ui.components.composes.InputSpace
import com.example.ebs.utils.getGredien


@Composable
fun SignInScreen(
    onNavigateMenu: () -> Unit,
    onNavigateSignUp: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
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
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Center
        )


        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Ada sesuatu yang tidak boleh dilewatkan agar bisa eksplor lebih jauh lagi pada aplikasi ini",
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.7f)
        )


        Spacer(modifier = Modifier.height(64.dp))
        InputSpace("Username")
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
                    .background(getGredien(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary
                    ))
            ){
                Text(
                    text = "Login",
                    textAlign = TextAlign.Center,
                    color = Color.White,
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
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface)
            ){
                Text(
                    text = "Lanjutkan dengan Google",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurface,
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
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onBackground
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .clickable { onNavigateSignUp() }
        )
    }
}

//@DarkLightPreviews
//@Composable
//fun PreviwSignin(){
//    EBSTheme {
//        SignInScreen()
//    }
//}

