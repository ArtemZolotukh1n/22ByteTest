package com.example.a22bytetest.di

import com.example.a22bytetest.data.repos.QuizScreenRepo
import dagger.Module
import dagger.Provides

@Module
class QuizModule {
    @Provides
    fun provideRandomRecipeRepo(): QuizScreenRepo {
        return QuizScreenRepo()
    }
}
