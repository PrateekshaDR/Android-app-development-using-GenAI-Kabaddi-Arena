package com.kabaddiarena.presentation.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object OTPVerification : Screen("otp_verification/{phoneNumber}") {
        fun createRoute(phoneNumber: String) = "otp_verification/$phoneNumber"
    }
    object Home : Screen("home")
}
