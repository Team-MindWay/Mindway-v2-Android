package com.chobo.presentation.view.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.chobo.presentation.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

val pretendard = FontFamily(
    Font(R.font.pretendard_regular),
    Font(R.font.pretendard_semi_bold)
)

val Typography = Typography(
    headlineLarge = TextStyle( //h1
        fontSize = 32.sp,
        fontFamily = pretendard,
        lineHeight = 38.4.sp
    ),
    headlineMedium = TextStyle( //h2
        fontSize = 28.sp,
        fontFamily = pretendard,
        lineHeight = 33.6.sp
    ),
    headlineSmall = TextStyle( //h3
        fontSize = 24.sp,
        fontFamily = pretendard,
        lineHeight = 31.2.sp
    ),
    bodyLarge = TextStyle( //m1
        fontSize = 20.sp,
        fontFamily = pretendard,
        lineHeight = 30.sp
    ),
    bodyMedium = TextStyle( //m2
        fontSize = 18.sp,
        fontFamily = pretendard,
        lineHeight = 27.sp
    ),
    bodySmall = TextStyle( //m3
        fontSize = 16.sp,
        fontFamily = pretendard,
        lineHeight = 24.sp
    ),
    labelLarge = TextStyle( //lable
        fontSize = 14.sp,
        fontFamily = pretendard,
        lineHeight = 21.sp
    )
)