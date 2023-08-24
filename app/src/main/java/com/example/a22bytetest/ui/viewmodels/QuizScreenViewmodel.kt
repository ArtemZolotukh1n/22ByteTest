package com.example.a22bytetest.ui.viewmodels

import android.app.Application
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.a22bytetest.R
import com.example.a22bytetest.data.data.QuizData
import com.example.a22bytetest.data.repos.QuizScreenRepo
import com.example.a22bytetest.ui.viewmodels.state.QuizScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class QuizScreenViewModel @Inject constructor(
    private val application: Application,
    private val quizScreenRepo: QuizScreenRepo
) : ViewModel() {

    private val _uiState = MutableStateFlow(QuizScreenState())
    val uiState: StateFlow<QuizScreenState> = _uiState.asStateFlow()
    val QUESTION_CAP = 10

    private val playerAnswers: MutableMap<Int, Boolean> = mutableMapOf()

    var correctAnswersAmount = 0
        private set

    init {
        Log.d(
            application.applicationContext.getString(R.string.quiz_view_model),
            application.applicationContext.getString(R.string.quiz_viewmodel_log_msg)
        )
        fetchNewQuestion()
    }

    private fun fetchNewQuestion() {
        viewModelScope.launch {
            val randomImages = quizScreenRepo.getRandomImages()
            val correctImageId = randomImages.random()
            val correctAnswer = quizScreenRepo.getCorrectAnswerForImage(correctImageId)
            _uiState.update {
                it.copy(
                    quizData = QuizData(correctAnswer!!, correctImageId, randomImages),
                )
            }
        }
    }

    fun playerAnswer(isCorrect: Boolean) {
        val currentQuestion = _uiState.value.quizData?.sentence
        if (currentQuestion != null) {
            playerAnswers[currentQuestion] = isCorrect
        }

        if (isCorrect) {
            correctAnswersAmount++
            removeImageFromImagePool(_uiState.value.quizData!!.correctImageIndex)
        }
        fetchNewQuestion()
        _uiState.update {
            it.copy(
                totalQuestionsAnswered = it.totalQuestionsAnswered + 1
            )
        }
    }

    private fun removeImageFromImagePool(@DrawableRes imageResId: Int) {
        viewModelScope.launch {
            quizScreenRepo.removeImage(imageResId)
        }
    }

    fun getPlayerAnswers(): Map<Int, Boolean> {
        return playerAnswers.toMap()
    }
}

class ViewModelFactory @Inject constructor(
    myViewModelProvider: Provider<QuizScreenViewModel>,
) : ViewModelProvider.Factory {
    private val providers = mapOf<Class<*>, Provider<out ViewModel>>(
        QuizScreenViewModel::class.java to myViewModelProvider
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return providers[modelClass]!!.get() as T
    }
}
