package com.example.m6lesson1

import android.graphics.Paint.Style
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.m6lesson1.ui.theme.M6Lesson1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserInfo()
        }
    }

    @Composable
    fun UserInfo() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row {
                CircleImage(100)
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
                        Toast.makeText(this@MainActivity, "Эта функция ещё не доступна", Toast.LENGTH_SHORT).show()
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
        }
    }

    @Composable
    fun CircleImage(height: Int){
        Image(
            modifier = Modifier
                .size(height.dp)
                .clip(CircleShape)
                .border(BorderStroke(1.dp, Color.Blue), shape = CircleShape),
            painter = painterResource(R.drawable.megumi_fushiguro),
            contentDescription = "User profile photo"
        )
    }

    @Composable
    fun HobbiesList(id: Int, text: String) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(modifier = Modifier
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
    fun BoldBigText(text:String){
        Text(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            text = text
        )
    }

    @Preview
    @Composable
    fun UserInfoPreview() {
        UserInfo()
    }
}

