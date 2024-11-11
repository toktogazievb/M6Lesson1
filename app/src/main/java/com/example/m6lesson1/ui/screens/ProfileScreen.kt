package com.example.m6lesson1.ui.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.m6lesson1.R

@Composable
fun ProfileScreen() {
    UserInfo()
}

private val friendsAvatar = listOf(
    R.drawable.satoru_gojo,
    R.drawable.inumaki_toge,
    R.drawable.nobara_kugisaki,
    R.drawable.panda,
    R.drawable.yuta_okotsu,
    R.drawable.zenin_maki)


@Composable
fun UserInfo() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row {
            CircleImage(100, R.drawable.megumi_fushiguro)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BoldBigText("Мегуми Фушигуро")
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Canvas(
                        modifier = Modifier
                            .wrapContentSize()
                            .clip(CircleShape)
                            .size(12.dp)
                    ) {
                        drawRect(
                            color = Color.Green,
                        )
                    }
                    Text(
                        modifier = Modifier.padding(horizontal = 6.dp),
                        fontSize = 20.sp,
                        text = "online"
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        BoldBigText("Обо мне")
        Spacer(modifier = Modifier.height(12.dp))
        Column(horizontalAlignment = Alignment.End) {
            Text(
                fontSize = 16.sp,
                color = Color.Gray,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Light,
                text = "伏黒恵ふしぐろめぐみ — студент первого года в Столичной технической школе магии, академии, где я стал магом и разрабатываю проклятые техники для борьбы с проклятыми духами, существами, проявляющимися из проклятой энергии из-за негативных эмоций, исходящих от людей. Я являюсь потомком Клана Зенин, одного из главных кланов, доминирующих в мире колдовства."
            )
            Button(modifier = Modifier.padding(top = 12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                onClick = {
                    Toast.makeText(
                        context,
                        "Эта функция ещё не доступна",
                        Toast.LENGTH_SHORT
                    ).show()
                }) {
                Text(text = "Редактировать", color = Color.Magenta)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            HobbiesList(R.drawable.ic_paw, "Кинология")
            HobbiesList(R.drawable.ic_seal, "Магические печати")
            HobbiesList(R.drawable.ic_studying, "Учёба")
        }
        Spacer(modifier = Modifier.height(12.dp))
        BoldBigText("Друзья")
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {
            items(friendsAvatar) { avatar ->
                Image(
                    painter = painterResource(avatar),
                    contentDescription = "Friend Avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(64.dp)
                        .padding(4.dp)
                        .clip(CircleShape)
                        .border(BorderStroke(1.dp, Color.Cyan), shape = CircleShape)
                )
            }
        }
    }
}

@Composable
fun CircleImage(height: Int, id: Int) {
    Image(
        modifier = Modifier
            .size(height.dp)
            .clip(CircleShape)
            .border(BorderStroke(1.dp, Color.Blue), shape = CircleShape),
        painter = painterResource(id),
        contentDescription = "User profile photo"
    )
}

@Composable
fun HobbiesList(id: Int, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier
                .size(24.dp)
                .padding(end = 8.dp),
            painter = painterResource(id),
            contentDescription = ""
        )
        Text(
            fontStyle = FontStyle.Italic,
            fontSize = 16.sp,
            text = text
        )
    }
}

@Composable
fun BoldBigText(text: String) {
    Text(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        text = text
    )
}
