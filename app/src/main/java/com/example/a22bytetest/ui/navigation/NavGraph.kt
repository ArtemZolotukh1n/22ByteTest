package com.example.a22bytetest.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.a22bytetest.ui.screen_size.WindowInfo
import com.example.a22bytetest.ui.screens.quiz.QuizScreen
import com.example.a22bytetest.ui.screens.result.ResultScreen
import com.example.a22bytetest.ui.screens.start_game.StartGameScreen
import com.example.a22bytetest.ui.viewmodels.QuizScreenViewModel

@Composable
fun NavGraph(
    navHostController: NavHostController,
    quizScreenViewModel: QuizScreenViewModel,
    windowInfo: WindowInfo,
) {
    NavHost(navController = navHostController, startDestination = Screen.StartScreen.route) {
        composable(Screen.StartScreen.route) {
            StartGameScreen(
                navHostController,
                windowInfo
            )
        }

        composable(Screen.QuizScreen.route) {
            QuizScreen(
                navHostController,
                quizScreenViewModel,
                windowInfo
            )
        }

        composable(Screen.ResultScreen.route.plus("/{playerScore}/{totalQuestions}")) { backStackEntry ->
            ResultScreen(
                backStackEntry.arguments?.getString("playerScore"),
                backStackEntry.arguments?.getString("totalQuestions"),
                quizScreenViewModel.getPlayerAnswers(),
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}
