package com.example.ebs.ui.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ebs.R
import com.example.ebs.ui.AppViewModelProvider
import com.example.ebs.ui.components.DarkPreview
import com.example.ebs.ui.components.LightPreview
import com.example.ebs.ui.components.composes.CenterColumn
import com.example.ebs.ui.components.composes.CenterRow
import com.example.ebs.ui.components.composes.Indicator
import com.example.ebs.ui.components.composes.MyPage
import com.example.ebs.ui.components.composes.TextContentM
import com.example.ebs.ui.components.composes.TextContentS
import com.example.ebs.ui.components.composes.TextTitleL
import com.example.ebs.ui.components.composes.TextTitleM
import com.example.ebs.ui.components.getGredienBackground
import com.example.ebs.ui.navigation.NavigationHandler
import com.example.ebs.ui.theme.EBSTheme
import dev.chrisbanes.haze.HazeState

@Composable
fun DashboardScreen(
    navHandler: NavigationHandler,
    hazeState: HazeState,
    viewModel: DashboardViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val angka by viewModel.counter.collectAsState()
    MyPage(
        hazeState,
        modifier = Modifier
            .background(getGredienBackground(
                MaterialTheme.colorScheme.primary,
                MaterialTheme.colorScheme.background.copy(
                    red = 0.98f,
                    blue = 0.98f,
                    green = 0.98f
                )
        ))
    ){
        Greeting()
        Trending(angka)
        Sorotan()
    }
}

@Composable
fun Greeting(){
    CenterRow(
        hArr = Arrangement.SpaceBetween,
        vAli = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp, horizontal = 30.dp)
    ){
        Column {
            TextTitleL("Hallo, Aldo!")
            TextTitleM(buildAnnotatedString {
                withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                    append("Ayo Deteksi Sampah")
                }
            }, mod = true)
            TextTitleM(buildAnnotatedString {
                withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                    append("elektronikmu.")
                }
            }, mod = true)
        }
        CenterRow(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.background)
        ){
            Box(
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painterResource(R.drawable.bell),
                    contentDescription = "Notification",
                    tint = MaterialTheme.colorScheme.onSurface,
                )
                if(true) {
                    CenterRow(
                        modifier = Modifier
                            .absoluteOffset(x = 5.dp)
                            .padding(bottom = 20.dp)
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary)
                    ) {}
                }
            }
        }
    }
}

@Composable
fun Trending(angka: Int){
    HeadlineDashboard {
        TextTitleM("Terkini")
        Text(angka.toString())
    }
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ){
        items(5) {
            CardDashboard(
                modifier = Modifier
                    .height(125.dp)
                    .width(240.dp)
            ){
                CenterColumn(
                    vArr = Arrangement.SpaceBetween,
                    hAli = Alignment.Start,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(top = 10.dp, bottom = 10.dp, end = 5.dp)
                ) {
                    Column {
                        TextContentS("Kategori: Smarphone")
                        TextContentS("Jumlah: 1")
                        TextContentS("Prediksi Harga: Rp. 50.000")
                    }
                    Indicator("Pending", Color(0xFFE27700))
                }
            }
        }
    }
}

@Composable
fun Sorotan(){
    HeadlineDashboard{
        TextTitleM("Sorotan")
    }
    LazyColumn{
        items(5) {
            CardDashboard(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth(0.9f)
            ){
                CenterColumn(
                    vArr = Arrangement.SpaceEvenly,
                    hAli = Alignment.Start,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(top = 2.dp, bottom = 2.dp, end = 5.dp)
                ) {
                    Column {
                        TextContentM("Kategori: Smarphone")
                        TextContentM("Jumlah: 1")
                    }
                    Indicator("Pending", Color(0xFFE27700))
                }
            }
        }
    }
}

@Composable
fun HeadlineDashboard(
    hArr: Arrangement.Horizontal = Arrangement.SpaceBetween,
    content: @Composable () -> Unit
){
    CenterRow(
        hArr = hArr,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, top = 10.dp)
    ) {
        content()
    }
}

@Composable
fun CardDashboard(
    modifier: Modifier = Modifier,
    photo: Int = R.drawable.nopicture,
    content: @Composable () -> Unit,
){
    Card (
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(5.dp)
    ){
        CenterRow(
            hArr = Arrangement.Start,
            modifier = modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(vertical = 5.dp)
        ) {
            Image(
                painterResource(photo),
                contentDescription = "Icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
            )
            content()
        }
    }
}

@DarkPreview
@Composable
fun PreviewCardDashboard1() {
    EBSTheme {
        CenterColumn {
            Trending(angka = 1)
            Sorotan()
        }
    }
}

@LightPreview
@Composable
fun PreviewCardDashboard2() {
    EBSTheme {
        CenterColumn {
            Trending(angka = 1)
            Sorotan()
        }
    }
}
