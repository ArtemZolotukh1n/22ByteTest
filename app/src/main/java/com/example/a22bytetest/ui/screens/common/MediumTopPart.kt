package com.example.a22bytetest.ui.screens.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.a22bytetest.R
import com.example.a22bytetest.common.standardQuadTo
import com.example.a22bytetest.ui.screen_size.WindowInfo
import com.example.a22bytetest.ui.theme.LightBlue

@Composable
fun MediumTopPart(
    modifier: Modifier = Modifier,
    windowInfo: WindowInfo
) {
    Box {
        Canvas(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth()
        ) {
            val screenWidth = size.width
            val screenHeight = size.height
            val lightPoint1 = Offset(0f, screenHeight * 0.80f)
            val lightPoint2 = Offset(screenWidth * 0.10f, screenHeight * 0.90f)
            val lightPoint3 = Offset(screenWidth * 0.55f, screenHeight * 0.85f)
            val lightPoint4 = Offset(screenWidth * 0.95f, screenHeight * 1.05f)
            val lightPoint5 = Offset(screenWidth * 1.3f, screenHeight * 0.75f)

            val coloredPath = Path().apply {
                moveTo(lightPoint1.x, lightPoint1.y)
                standardQuadTo(lightPoint1, lightPoint2)
                standardQuadTo(lightPoint2, lightPoint3)
                standardQuadTo(lightPoint3, lightPoint4)
                standardQuadTo(lightPoint4, lightPoint5)
                lineTo(screenWidth, 0f)
                lineTo(0f, 0f)
                close()
            }

            drawPath(
                path = coloredPath, color = LightBlue
            )

        }
        Box(
            modifier = modifier
        ) {
            // Жаль, что не векторная
            Image(
                painter = painterResource(id = R.drawable.books),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(windowInfo.screenHeight / 3f)
            )
        }
    }
}
