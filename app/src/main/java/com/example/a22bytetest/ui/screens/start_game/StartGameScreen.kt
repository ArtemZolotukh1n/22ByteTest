package com.example.a22bytetest.ui.screens.start_game

import androidx.compose.runtime.Composable
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
        )
    }
}
