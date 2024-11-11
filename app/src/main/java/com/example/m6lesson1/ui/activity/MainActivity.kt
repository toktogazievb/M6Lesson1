package com.example.m6lesson1.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.m6lesson1.ui.screens.ProfileScreen
import com.example.m6lesson1.ui.screens.Screens
import com.example.m6lesson1.ui.screens.onboard.ConfirmationScreen
import com.example.m6lesson1.ui.screens.onboard.RegistrationScreen
import com.example.m6lesson1.ui.screens.onboard.WelcomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreakyApp()
        }
    }

    @Composable
    private fun FreakyApp() {
        val navController = rememberNavController()
        NavHost(navController, startDestination = Screens.WelcomeScreen.route) {
            composable(Screens.WelcomeScreen.route) {
                WelcomeScreen(navigateToRegistrationScreen = {
                    navController.navigate(Screens.RegistrationScreen.route)
                })
            }
            composable(Screens.RegistrationScreen.route) {
                RegistrationScreen(navigateToConfirmationScreen = { login, password ->
                    navController.navigate("ConfirmationScreen/$login/$password")
                })
            }
            composable(route = Screens.ConfirmationScreen.route,
                arguments = listOf(
                    navArgument(name = "login") { type = NavType.StringType },
                    navArgument(name = "password") { type = NavType.StringType }
                )) { backStackEntry ->
                val login = backStackEntry.arguments?.getString("login") ?: ""
                val password = backStackEntry.arguments?.getString("password") ?: ""
                ConfirmationScreen(
                    navigateToProfileScreen = {
                        navController.navigate(Screens.ProfileScreen.route)
                    },
                    login = login,
                    password = password
                )
            }
            composable(Screens.ProfileScreen.route) {
                ProfileScreen()
            }
        }
    }
}

