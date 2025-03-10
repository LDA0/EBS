package com.example.ebs.ui.dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ebs.R
import com.example.ebs.ui.AppViewModelProvider
import com.example.ebs.ui.components.composes.MyPage
import com.example.ebs.ui.components.composes.TopBer
import com.example.ebs.ui.navigation.NavigationHandler
import com.example.ebs.ui.components.getGredienButton
import dev.chrisbanes.haze.HazeState

@Composable
fun ProfileScreen(
    navHandler: NavigationHandler,
    hazeState: HazeState,
    viewModel: DashboardViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    Scaffold(
        topBar = {
            TopBer(title = "Profile")
        },
    ) { padding ->
        MyPage(
            hazeState,
            modifier = Modifier
                .padding(padding)
        ){
            Spacer(modifier = Modifier.height(32.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .height(168.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            getGredienButton(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary
                            )
                        )
                ){
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .align(Alignment.Center)
                    ){
                        Text(
                            text = "Aldo Nitehe Lase",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.SemiBold
                            ),
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            modifier = Modifier
                                .clickable { navHandler.dialogueSetting() }
                        )
                        Text(
                            text = "ldao089@jimail.com | 089789462909",
                            style = MaterialTheme.typography.labelSmall,
                            textAlign = TextAlign.Center,
                            color = Color.White,
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.LightGray)
                            .padding(vertical = 4.dp, horizontal = 8.dp)
                            .align(Alignment.TopEnd)
                    ) {
                        Text(
                            text = "Ubah",
                            style = MaterialTheme.typography.labelSmall,
                            textAlign = TextAlign.Center,
                            color = Color.White,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Card(
                colors = CardDefaults.cardColors().copy(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                border = BorderStroke(1.dp,Color.LightGray),
                modifier = Modifier
                    .fillMaxWidth(0.85f)
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                Column {
                    ProfileItem("Lokasi",painterResource(R.drawable.map_marker))
                    ProfileItem("Bantuan",painterResource(R.drawable.help_circle))
                    ProfileItem("Beri Kami Nilai",painterResource(R.drawable.comment_alert))
                    ProfileItem("Kontak Kami",painterResource(R.drawable.account_box))
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun ProfileItem(item: String,icon: Painter){
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 24.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = Color.LightGray,
            modifier = Modifier
                .padding(end = 16.dp)
        )
        Text(item)
    }
}