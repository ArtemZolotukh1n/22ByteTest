package com.example.a22bytetest

import android.app.Application
import com.example.a22bytetest.di.AppComponent
import com.example.a22bytetest.di.DaggerAppComponent

class MyApp() : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(application = this)
    }
}
