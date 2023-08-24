package com.example.a22bytetest.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.a22bytetest.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontSize = 20.sp,
        lineHeight = 20.sp,
        fontFamily = FontFamily(
            Font(R.font.oswald_regular, FontWeight.Normal)
        ),
        fontWeight = FontWeight(600),
        color = LightBlue,
        textAlign = TextAlign.Center,
    ),
    bodyMedium = TextStyle(
        color = QuestionTextColor,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 22.sp,
        letterSpacing = 1.0.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.2.sp
    ),
    titleMedium = TextStyle(
        fontSize = 40.sp,
        lineHeight = 40.sp,
        fontFamily = FontFamily(
            Font(R.font.oswald_regular, FontWeight.Normal)
        ),
        fontWeight = FontWeight(500),
        color = LightBlue,
        textAlign = TextAlign.Center,
    ),
    labelLarge = TextStyle(
        fontSize = 30.sp,
        lineHeight = 30.sp,
        fontFamily = FontFamily(
            Font(R.font.oswald_regular, FontWeight.Normal)
        ),
        fontWeight = FontWeight(700),
        textAlign = TextAlign.Center,
    )

)
