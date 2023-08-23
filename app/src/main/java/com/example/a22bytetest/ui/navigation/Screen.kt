package com.example.a22bytetest.ui.navigation

sealed class Screen(val route: String) {
    object StartScreen : Screen("start_screen")
    object ResultScreen : Screen("result_screen")
    object QuizScreen : Screen("quiz_screen")
}
