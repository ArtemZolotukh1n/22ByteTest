package com.example.a22bytetest.ui.viewmodels.state

import com.example.a22bytetest.data.data.QuizData

data class QuizScreenState(
    val quizData: QuizData? = null,
    val totalQuestionsAnswered: Int = 0,
)
