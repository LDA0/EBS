package com.example.ebs.ui.starter

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ebs.R
import com.example.ebs.ui.AppViewModelProvider
import com.example.ebs.ui.components.composes.AestheticButton
import com.example.ebs.ui.components.composes.CenterColumn
import com.example.ebs.ui.components.composes.CenterRow
import com.example.ebs.ui.components.composes.InputSpace
import com.example.ebs.ui.components.composes.TextContentL
import com.example.ebs.ui.components.composes.TextContentM
import com.example.ebs.ui.components.composes.TextTitleL
import com.example.ebs.ui.navigation.NavigationHandler


@Composable
fun SignInScreen(
    navHandler: NavigationHandler,
    SignedIn: MutableState<Boolean>,
    viewModel: SignInViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    CenterColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        TextTitleL(buildAnnotatedString {
            withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("Halo,")
            }
            append(" Teman!")
        }, mod = true)

        Spacer(modifier = Modifier.height(16.dp))

        TextContentL("Ada sesuatu yang tidak boleh")
        TextContentL("dilewatkan agar bisa eksplor lebih jauh")
        TextContentL("lagi pada aplikasi ini")

        Spacer(modifier = Modifier.height(64.dp))

        InputSpace("Username")
        InputSpace("Password")

        Spacer(modifier = Modifier.height(16.dp))

        AestheticButton(
            text = "Login",
            onClick = {
                SignedIn.value = true
                navHandler.menuFromSignIn()
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        CenterRow(
            modifier = Modifier
                .height(50.dp)
        ){
            CenterColumn(
                modifier = Modifier
                    .width(100.dp)
                    .fillMaxHeight()
            ) {
                HorizontalDivider(color = Color.Gray)
            }
            Text(
                text = "Or",
                color = Color.Gray,
                modifier = Modifier
                    .padding(start = 5.dp, bottom = 5.dp, end = 5.dp)
            )
            CenterColumn(
                modifier = Modifier
                    .width(100.dp)
                    .fillMaxHeight()
            ) {
                HorizontalDivider(color = Color.Gray)
            }
        }

        Card(
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(60.dp)
        ) {
            CenterRow (
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

        CenterRow {
            TextContentM("Belum punya akun? ")
            TextContentM(
                buildAnnotatedString {
                    withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                        append("Daftar")
                    }
                },
                mod = true,
                modifier = Modifier
                    .clickable { navHandler.signUpFromSignIn() }
            )
        }
    }
}

//@DarkLightPreviews
//@Composable
//fun PreviwSignin(){
//    EBSTheme {
//        SignInScreen()
//    }
//}

