package com.example.m6lesson1.ui.screens.onboard

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.m6lesson1.R

@Composable
fun WelcomeScreen(
    navigateToRegistrationScreen: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            fontWeight = FontWeight.W100,
            fontStyle = FontStyle.Italic,
            fontSize = 30.sp,
            text = "Добро пожаловать"
        )
        Image(
            painter = painterResource(R.drawable.ic_welcome_sun),
            contentDescription = "Image of Sun"
        )
        Button(
            onClick = { navigateToRegistrationScreen() },
            colors = ButtonDefaults.buttonColors(Color.DarkGray)
        ) {
            Text(
                text = "Продолжить",
                fontSize = 12.sp,
                color = Color.Magenta
            )
        }
    }
}
