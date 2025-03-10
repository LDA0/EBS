package com.example.ebs.ui.starter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ebs.ui.AppViewModelProvider
import com.example.ebs.ui.components.composes.AestheticButton
import com.example.ebs.ui.components.composes.CenterColumn
import com.example.ebs.ui.components.composes.CenterRow
import com.example.ebs.ui.components.composes.InputSpace
import com.example.ebs.ui.components.composes.TextContentM
import com.example.ebs.ui.components.composes.TextTitleL
import com.example.ebs.ui.navigation.NavigationHandler

@Composable
fun SignUpScreen(
    navHandler: NavigationHandler,
    viewModel: SignUpViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    CenterColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        TextTitleL("Buat Akun!")

        Spacer(modifier = Modifier.height(32.dp))

        InputSpace("Nama")
        InputSpace("Email")
        InputSpace("No. Telepon")
        InputSpace("Password")

        Spacer(modifier = Modifier.height(16.dp))

        AestheticButton(
            text = "Daftar",
            onClick = { navHandler.menuFromSignUp() }
        )

        Spacer(modifier = Modifier.height(32.dp))

        CenterRow {
            TextContentM("Sudah punya akun? ")
            TextContentM(
                buildAnnotatedString {
                    withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                        append("Login")
                    }
                },
                mod = true,
                modifier = Modifier
                    .clickable { navHandler.signInFromSignUp() }
            )
        }
    }
}