package com.example.ebs.ui.dashboard

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.ebs.ui.components.composes.MyPage
import com.example.ebs.ui.navigation.NavigationHandler
import dev.chrisbanes.haze.HazeState

@Composable
fun ScanScreen(
    navHandler: NavigationHandler,
    hazeState: HazeState
) {
    val currentContext = LocalContext.current

    val pickImageFromAlbumLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.PickMultipleVisualMedia(20)
    ) { urls ->

    }
    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { isImageSaved ->
        if (isImageSaved) {

        } else {

        }
    }
    val permissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { permissionGranted ->
        if (permissionGranted) {

        } else {
            Toast.makeText(currentContext, "In order to take pictures, you have to allow this app to use your camera", Toast.LENGTH_SHORT).show()
        }
    }

    val tempFileUrl: Uri by remember { mutableStateOf(Uri.parse("content://placeholder") ) }

//    LaunchedEffect(key1 = tempFileUrl) {
//        cameraLauncher.launch(tempFileUrl)
//    }
    CameraPermissionRequester {  }
    MyPage(
        hazeState,
        modifier = Modifier
            .padding(top = 60.dp)
    ){
        Button(onClick = {
            permissionLauncher.launch(Manifest.permission.CAMERA)
            cameraLauncher.launch(tempFileUrl)
        }) {
            Text(text = "Take a photo")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(onClick = {
            pickImageFromAlbumLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }) {
            Text(text = "Pick a picture")
        }
    }
}

@Composable
fun CameraPermissionRequester(onPermissionGranted: () -> Unit) {
    val context = LocalContext.current
    val cameraPermission = Manifest.permission.CAMERA
    val showDialog = remember { mutableStateOf(false) }

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Permission granted, proceed with camera-related tasks
            onPermissionGranted()
        } else {
            // Permission denied, handle accordingly (e.g., show a message)
        }
    }

    LaunchedEffect(key1 = true) {
        val permissionCheckResult = ContextCompat.checkSelfPermission(context, cameraPermission)
        if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
            // Permission is already granted, proceed with camera-related tasks
            onPermissionGranted()
        } else {
            // Permission is not granted, request it
            if ((context as ComponentActivity).shouldShowRequestPermissionRationale(cameraPermission)) {
                showDialog.value = true
            } else {
                launcher.launch(cameraPermission)
            }
        }
    }
    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text("Camera Permission Required") },
            text = { Text("This app needs camera access to take photos.") },
            confirmButton = {
                Button(onClick = {
                    showDialog.value = false
                    launcher.launch(cameraPermission)
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}