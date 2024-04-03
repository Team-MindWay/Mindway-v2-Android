package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun GoalReadingGraph(
    modifier: Modifier = Modifier,
    numBooksRead: Int,
    maxBooksRead: Int,
    isCurrentDate: Boolean,
    today: String,
) {
    MindWayAndroidTheme { colors, typography ->
        val height = ((27 * numBooksRead) / maxBooksRead + 1).toFloat().dp
        val graphColor = if (!isCurrentDate) colors.GRAY200 else colors.MAIN
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Bottom),
            modifier = modifier,
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = numBooksRead.toString(),
                    style = typography.labelLarge,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal,
                    color = colors.GRAY800,
                    modifier = Modifier
                        .width(9.dp)
                        .height(21.dp),
                )
                Spacer(
                    modifier = Modifier
                        .height(height)
                        .fillMaxWidth(0.667f)
                        .background(
                            color = graphColor,
                            shape = RoundedCornerShape(
                                topStart = 4.dp,
                                topEnd = 4.dp,
                            )
                        )
                )
            }
            Text(
                text = today,
                style = typography.labelLarge,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                color = colors.GRAY800,
                modifier = Modifier
                    .width(9.dp)
                    .height(21.dp),
            )
        }
    }
}