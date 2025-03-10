package com.example.ebs.ui.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ebs.R
import com.example.ebs.data.repositories.remote.DataTest
import com.example.ebs.ui.AppViewModelProvider
import com.example.ebs.ui.components.composes.CenterColumn
import com.example.ebs.ui.navigation.NavigationHandler
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeSource

@Composable
fun DetectionListScreen(
    navHandler: NavigationHandler,
    hazeState: HazeState,
    modifier: Modifier = Modifier,
    viewModel: DetectionListViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    CenterColumn(
        modifier = Modifier
            .fillMaxSize()
            .hazeSource(hazeState)
    ) {
        val detectionListUiState by viewModel.detectionListUiState.collectAsState()
        println("DetectionListScreen: $detectionListUiState")
        when (detectionListUiState) {
            is DetectionListUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
            is DetectionListUiState.Success -> ResultScreen((detectionListUiState as DetectionListUiState.Success).dataTestList, modifier)
            else -> ErrorScreen(viewModel::getData, modifier = modifier.fillMaxSize())
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Icon(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.walk),
        contentDescription = "R.string.loading"
    )
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    CenterColumn(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.missed),
            contentDescription = ""
        )
        Text("Failed", modifier = Modifier.padding(16.dp))
        Button(onClick = retryAction) {
            Text("Retry")
        }
    }
}

@Composable
fun ResultScreen(photos: DataTest, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = photos.toString())
    }
}