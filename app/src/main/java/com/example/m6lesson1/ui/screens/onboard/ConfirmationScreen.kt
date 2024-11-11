package com.example.m6lesson1.ui.screens.onboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ConfirmationScreen(
    navigateToProfileScreen: () -> Unit,
    login: String, password: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConfirmText(login)
        ConfirmText(password)
        Button(
            onClick = { navigateToProfileScreen() },
            colors = ButtonDefaults.buttonColors(Color.DarkGray)
        ) {
            Text(
                text = "Подтвердить",
                fontSize = 16.sp,
                color = Color.Magenta
            )
        }
    }
}

@Composable
fun ConfirmText(text: String) {
    Text(
        fontWeight = FontWeight.W100,
        fontStyle = FontStyle.Italic,
        fontSize = 20.sp,
        text = text
    )
}
