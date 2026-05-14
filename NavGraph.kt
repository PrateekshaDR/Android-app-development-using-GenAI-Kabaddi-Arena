package com.kabaddiarena.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.kabaddiarena.presentation.screens.auth.LoginScreen
import com.kabaddiarena.presentation.screens.auth.OTPVerificationScreen
import com.kabaddiarena.presentation.screens.home.HomeScreen
import com.kabaddiarena.presentation.screens.splash.SplashScreen

@Composable
fun KabaddiArenaNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Login.route) {
            LoginScreen(
                onNavigateToOTP = { phoneNumber ->
                    navController.navigate(Screen.OTPVerification.createRoute(phoneNumber))
                }
            )
        }
        composable(
            route = Screen.OTPVerification.route,
            arguments = listOf(navArgument("phoneNumber") { type = NavType.StringType })
        ) { backStackEntry ->
            val phoneNumber = backStackEntry.arguments?.getString("phoneNumber") ?: ""
            OTPVerificationScreen(
                phoneNumber = phoneNumber,
                onBack = { navController.popBackStack() },
                onVerify = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToMatchSetup = {
                    // Navigate to Match Setup
                }
            )
        }
    }
}
