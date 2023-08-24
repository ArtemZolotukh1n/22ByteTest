package com.example.a22bytetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.a22bytetest.ui.navigation.NavGraph
import com.example.a22bytetest.ui.screen_size.rememberWindowInfo
import com.example.a22bytetest.ui.theme._22ByteTestTheme
import com.example.a22bytetest.ui.viewmodels.QuizScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: QuizScreenViewModel by viewModels {
            (application as MyApp).appComponent.viewModelsFactory()
        }

        setContent {
            val navController = rememberNavController()
            val windowInfo = rememberWindowInfo()
            _22ByteTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavGraph(
                        navHostController = navController,
                        quizScreenViewModel = viewModel,
                        windowInfo = windowInfo
                    )
                }
            }
        }
    }
}

