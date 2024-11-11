package com.example.m6lesson1.ui.screens.onboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun RegistrationScreen(
    navigateToConfirmationScreen: (login: String, password: String) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var login: String = inputText("Логин")
        var password: String = inputText("Пароль")
        Button(
            onClick = { navigateToConfirmationScreen(login, password) },
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

@Composable
fun inputText(nameOfField: String): String {
    val text = remember { mutableStateOf(String()) }
    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        label = { Text(text = nameOfField) })
    return text.value
}
