package com.example.a22bytetest.data.repos


interface QuizScreenRepository {
    suspend fun getRandomImages(): List<Int>

    suspend fun removeImage(imageId: Int)

    suspend fun getCorrectAnswerForImage(imageId: Int): Int?

}
