package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.component.icon.PlusIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun GoalReadingPlusCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    MindWayAndroidTheme { colors, _ ->
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .shadow(
                    elevation = 20.dp,
                    spotColor = colors.CardShadow,
                    ambientColor = colors.CardShadow
                )
                .background(
                    color = colors.WHITE,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .clickableSingle { onClick() }
                .padding(16.dp)
        ) {
            PlusIcon(modifier = Modifier.fillMaxSize())
        }
    }
}

@Preview
@Composable
fun GoalReadingPlusCardPreview() {
    GoalReadingPlusCard(Modifier.height(100.dp)) {}
}