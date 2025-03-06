package com.example.ebs.ui.dialogue

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.ebs.R
import com.example.ebs.ui.components.composes.CenterColumn
import com.example.ebs.ui.components.composes.CenterRow
import com.example.ebs.ui.components.composes.MyCard
import com.example.ebs.ui.components.composes.MyIcon


@Composable
fun ApplyRequest() {
    Card{
        CenterColumn(
            modifier = Modifier
                .padding(vertical = 20.dp, horizontal = 20.dp)
                .width(400.dp)
        ){
            CenterRow(
                hArr = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ){
                CenterRow(
                    hArr = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                ) {
                    Text(text = "Smartphone")
                    MyIcon(
                        painterResource(id = R.drawable.recycle),
                        contentDescription = "avItem.name"
                    )
                }
                MyIcon(
                    painterResource(id = R.drawable.close),
                    contentDescription = "avItem.name"
                )
            }
            MyCard(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                CenterRow(
                    hArr = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ){
                    CenterColumn{
                        Text(text = "Kategori")
                        Text(text = "Jenis")
                    }
                    CenterColumn{
                        Text(text = "Jumlah")
                        Text(text = "1")
                    }
                    CenterColumn{
                        Text(text = "Estimasi Harga")
                        Text(text = "Rp. 100.000")
                    }
                }
            }
            MyCard {
                CenterColumn(
                    hAli = Alignment.Start,
                    modifier = Modifier
                        .padding(10.dp)
                ){
                    Text(text = "Pilih Jadwal Jemput (Setiap hari minggu)")
                    Row {
                        MyCard(
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                        ){
                            CenterColumn{
                                Text(text = "Kategori")
                                Text(text = "Jenis")
                            }
                        }
                        MyCard(
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                        ){
                            CenterColumn{
                                Text(text = "Kategori")
                                Text(text = "Jenis")
                            }
                        }
                        MyCard(
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                        ){
                            CenterColumn{
                                Text(text = "Kategori")
                                Text(text = "Jenis")
                            }
                        }
                        MyCard(
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                        ){
                            CenterColumn{
                                Text(text = "Kategori")
                                Text(text = "Jenis")
                            }
                        }
                    }
                    Row {
                        MyCard(
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                        ){
                            Text(text = "Kategori")
                        }
                        MyCard(
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                        ){
                            Text(text = "Kategori")
                        }
                        MyCard(
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                        ){
                            Text(text = "Kategori")
                        }
                    }
                }
            }
            MyCard {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Text(text="Catatan:")
                    Text(
                        text="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum",
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
            Button(onClick = {}) {
                Text(text = "Konfirmasi")
            }
        }
    }
}