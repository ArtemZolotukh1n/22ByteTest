package com.example.a22bytetest.ui.screens.quiz

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.a22bytetest.ui.screen_size.WindowInfo
import com.example.a22bytetest.ui.viewmodels.QuizScreenViewModel

@Composable
fun QuizScreen(
    navHostController: NavHostController,
    quizScreenViewModel: QuizScreenViewModel,
    windowInfo: WindowInfo
) {
    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
        CompactQuizScreen(
            navHostController = navHostController,
            quizScreenViewModel = quizScreenViewModel,
            modifier = Modifier.fillMaxSize()
        )
    } else {
        MediumQuizScreen()
    }
}
