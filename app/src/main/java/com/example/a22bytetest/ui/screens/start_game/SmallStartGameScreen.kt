package com.example.a22bytetest.ui.screens.start_game

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.a22bytetest.R
import com.example.a22bytetest.ui.navigation.Screen

@Composable
fun SmallStartGameScreen(navHostController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Button(
            shape = RectangleShape,
            onClick = {
                navHostController.navigate(Screen.QuizScreen.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier.border(
                width = 2.dp,
                MaterialTheme.colorScheme.onSurface,
                shape = RectangleShape
            )

        ) {
            Text(stringResource(R.string.start_button))
        }
    }
}
