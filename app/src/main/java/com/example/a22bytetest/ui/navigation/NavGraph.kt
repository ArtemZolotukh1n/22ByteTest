package com.example.a22bytetest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.a22bytetest.ui.screens.quiz.SmallQuizScreen
import com.example.a22bytetest.ui.screens.result.SmallResultScreen
import com.example.a22bytetest.ui.screens.start_game.SmallStartGameScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
) {
    NavHost(navController = navHostController, startDestination = Screen.StartScreen.route) {
        composable(Screen.StartScreen.route) {
            SmallStartGameScreen(navHostController)
        }

        composable(Screen.QuizScreen.route) {
            SmallQuizScreen(navHostController)
        }

        composable(Screen.ResultScreen.route) {
            SmallResultScreen()
        }
    }
}
