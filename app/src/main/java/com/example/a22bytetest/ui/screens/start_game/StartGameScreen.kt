package com.example.a22bytetest.ui.screens.start_game

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.a22bytetest.ui.screen_size.WindowInfo

@Composable
fun StartGameScreen(
    navHostController: NavHostController,
    windowInfo: WindowInfo
) {
    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
        CompactStartGameScreen(
            navHostController = navHostController,
        )
    } else {
        MediumStartGameScreen(
            navHostController = navHostController,
            windowInfo = windowInfo,
            modifier = Modifier.fillMaxSize()
        )
    }
}
