package com.example.ebs.ui.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ebs.R
import com.example.ebs.ui.AppViewModelProvider
import com.example.ebs.ui.components.composes.MyPage
import com.example.ebs.ui.navigation.NavigationHandler
import dev.chrisbanes.haze.HazeState

@Composable
fun DashboardScreen(
    navHandler: NavigationHandler,
    hazeState: HazeState,
    viewModel: DashboardViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    MyPage(hazeState){
        Greeting()
        Trending()
        Sorotan()
    }
}

@Composable
fun Greeting(){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 30.dp, horizontal = 30.dp)
    ){
        Column {
            Text("Hallo, Aldo!")
            Text("Ayo deteksi sampah")
            Text("elektronikmu.")
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = 20.dp)
                .size(50.dp)
                .clip(CircleShape)
        ){
            Icon(
                painterResource(R.drawable.bell),
                contentDescription = "Notification",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Composable
fun Trending(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    ) {
        Text("Terkini")
        Text("Lihat Semua")
    }
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ){
        items(5) {
            Card (
                modifier = Modifier.padding(10.dp)
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(10.dp)
                ) {
                    Image(
                        painterResource(R.drawable.image_5),
                        contentDescription = "Icon",
                        modifier = Modifier.size(100.dp)
                    )
                    Text("Item $it")
                }
            }
        }
    }
}

@Composable
fun Sorotan(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, top = 20.dp)
    ) {
        Text("Sorotan")
    }
    LazyColumn{
        items(5) {
            Card (
                modifier = Modifier.padding(10.dp)
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(10.dp)
                ) {
                    Image(
                        painterResource(R.drawable.image_5),
                        contentDescription = "Icon",
                        modifier = Modifier.size(100.dp)
                    )
                    Text("Item $it")
                }
            }
        }
    }
}
