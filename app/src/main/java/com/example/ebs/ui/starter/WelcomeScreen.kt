package com.example.ebs.ui.starter

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ebs.R
import com.example.ebs.ui.components.DarkLightPreviews
import com.example.ebs.ui.theme.EBSTheme

@Composable
fun WelcomeScreen(
    onNavigateLogIn: () -> Unit,
    onNavigateSignUp: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(top = 8.dp)
                .clip(RoundedCornerShape(16.dp))
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.45f)
                .background(color = MaterialTheme.colorScheme.primary)
        ) {
            Image(
                painter = painterResource(id = R.drawable.e_waste_illustration),
                contentDescription = "E-Waste Illustration",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(216.dp)
            )
        }
        Spacer(modifier = Modifier.height(48.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ){
            val textkusus = buildAnnotatedString {
                append("Cukup")
                withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                    append(" Pindai")
                }
                append(",")
            }
            Text(
                text = textkusus,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Kami Urus Sisanya!",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Teknologi cerdas kami akan mendeteksi jenis sampah elektronik Anda dan memberikan langkah mudah untuk mengelolanya",
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(0.7f)
            )
            Spacer(modifier = Modifier.height(48.dp))
            Row {
                Button(onClick = { onNavigateLogIn() }) {
                    Text(text = "Login")
                }
                Button(onClick = { onNavigateSignUp() }) {
                    Text(text = "Daftar")
                }
            }
            Spacer(modifier = Modifier.height(64.dp))
        }
    }
}

@DarkLightPreviews
@Composable
fun PreviwWelcome(){
    EBSTheme {
        WelcomeScreen(
            onNavigateSignUp = {},
            onNavigateLogIn = {}
        )
    }
}
