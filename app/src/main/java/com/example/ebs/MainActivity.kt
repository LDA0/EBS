package com.example.ebs

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.ebs.ui.navigation.MyNavigationg
import com.example.ebs.ui.theme.EBSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//      enableEdgeToEdge()
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        setContent {
            EBSTheme {
                val signedIn = remember { mutableStateOf(false) }
                MyNavigationg(signedIn)
            }
        }
    }
}