package com.example.a22bytetest.data.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class QuizData(
    @StringRes val sentence: Int,
    @DrawableRes val correctImageIndex: Int,
    val options: List<Int>
)
