package com.example.ebs.ui.dialogues

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.ebs.ui.dialogues.bases.CustomAlertDialogue
import com.example.ebs.ui.screens.MainViewModel

@Composable
fun Exit(
    viewModelMain: MainViewModel,
    modifier: Modifier = Modifier
) {
    val backTrig = remember { mutableStateOf(false) }
    CustomAlertDialogue(
        title = "Keluar Aplikasi",
        desc = "Apakah anda yakin ingin keluar dari aplikasi?",
        right = "Ya",
        left = "Tidak",
        modifier,
        rightAct = { viewModelMain.navHandler.closeApp() },
        leftAct = {
            if(!backTrig.value) {
                backTrig.value = true
                viewModelMain.navHandler.back()
            }
        }
    )
}
