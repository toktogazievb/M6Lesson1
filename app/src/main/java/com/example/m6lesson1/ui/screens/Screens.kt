package com.example.m6lesson1.ui.screens

sealed class Screens(val route: String) {

    data object WelcomeScreen : Screens("WelcomeScreen")
    data object RegistrationScreen : Screens("RegistrationScreen")
    data object ConfirmationScreen : Screens("ConfirmationScreen/{login}/{password}")
    data object ProfileScreen : Screens("ProfileScreen")
}