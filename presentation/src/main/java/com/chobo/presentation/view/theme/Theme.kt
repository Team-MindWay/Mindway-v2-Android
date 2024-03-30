package com.chobo.presentation.view.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import com.chobo.presentation.view.theme.color.ColorTheme
import com.chobo.presentation.view.theme.color.MindWayColor

@Composable
fun MindWayAndroidTheme(
    colors: ColorTheme = MindWayColor,
    typography: Typography = Typography,
    content: @Composable (colors: ColorTheme, typography: Typography) -> Unit
){
    content(colors, typography)
}