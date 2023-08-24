package com.example.a22bytetest.di

import android.app.Application
import com.example.a22bytetest.ui.viewmodels.ViewModelFactory
import dagger.BindsInstance
import dagger.Component

@Component(modules = [QuizModule::class])
interface AppComponent {
    fun viewModelsFactory(): ViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}
