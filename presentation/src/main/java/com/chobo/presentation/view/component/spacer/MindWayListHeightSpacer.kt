package com.chobo.presentation.view.component.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MindWayListSpacerM(modifier: Modifier = Modifier){
    Spacer(modifier = modifier.height(28.dp))
}

@Composable
fun MindWayListSpacerR(modifier: Modifier = Modifier){
    Spacer(modifier = modifier.height(16.dp))
}