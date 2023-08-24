package com.example.a22bytetest.ui.screens.start_game

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.a22bytetest.R
import com.example.a22bytetest.ui.navigation.Screen
import com.example.a22bytetest.ui.screen_size.WindowInfo
import com.example.a22bytetest.ui.screens.common.MediumTopPart

@Composable
fun MediumStartGameScreen(
    navHostController: NavHostController,
    windowInfo: WindowInfo,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        MediumTopPart(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            windowInfo = windowInfo
        )
        SpacerForPortraitMode(80.dp)
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = stringResource(R.string.game_rules),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            )
            SpacerForPortraitMode(80.dp)
            Button(
                onClick = {
                    navHostController.navigate(Screen.QuizScreen.route)
                },
                modifier = Modifier
                    .padding(bottom = 68.dp)
                    .width(300.dp)
                    .height(65.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFD4D0A),
                    contentColor = MaterialTheme.colorScheme.onSurface,
                ),
                shape = MaterialTheme.shapes.large
            ) {
                Text(
                    text = stringResource(R.string.play),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}

@Composable
fun SpacerForPortraitMode(dp: Dp) {
    if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT) {
        Spacer(modifier = Modifier.height(dp))
    }
}
