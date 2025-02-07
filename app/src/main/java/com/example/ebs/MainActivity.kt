package com.example.ebs

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import com.example.ebs.ui.cameraKatanya.AlbumViewModel
import com.example.ebs.ui.navigation.MyNavigationg
import com.example.ebs.ui.theme.EBSTheme
import kotlinx.coroutines.Dispatchers

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//      enableEdgeToEdge()
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val viewModel = AlbumViewModel(coroutineContext = Dispatchers.Default)

        setContent {
//            val windowSizeClass = calculateWindowSizeClass(this)
//            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                AlbumScreen(
//                    modifier = Modifier.padding(innerPadding),
//                    viewModel = viewModel
//                )
//            }
            EBSTheme {
                MyNavigationg()
            }
        }
    }
}