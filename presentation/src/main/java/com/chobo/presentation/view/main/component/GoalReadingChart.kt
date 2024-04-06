package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun GoalReadingChart(
    modifier: Modifier = Modifier,
    isHasData: Boolean,
    readingGoalGraphData: List<ReadingGoalGraphData> = listOf(),
) {
    MindWayAndroidTheme { colors, typography ->
        Column(
            verticalArrangement = if (isHasData) Arrangement.SpaceBetween
            else Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .shadow(
                    elevation = 20.dp,
                    spotColor = colors.CardShadow,
                    ambientColor = colors.CardShadow,
                )
                .background(
                    color = colors.WHITE,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .padding(
                    horizontal = 24.dp,
                    vertical = 28.dp
                ),
        ) {
            if (isHasData) {
                GoalReadingIndicator(
                    numBooksRead = readingGoalGraphData.sumOf { it.numBooksRead },
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.2419f)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxWidth(0.9091f)
                        .height(78.dp)
                ) {
                    readingGoalGraphData.forEach {
                        GoalReadingGraph(
                            numBooksRead = it.numBooksRead,
                            maxBooksRead = it.maxBooksRead,
                            isCurrentDate = it.isCurrentDate,
                            today = it.today,
                            modifier = Modifier
                                .width(16.dp)
                                .height(78.dp),
                        )
                    }
                }
            } else {
                Text(
                    text = stringResource(R.string.goal_reading_error),
                    style = typography.bodySmall,
                    fontWeight = FontWeight.Normal,
                    color = colors.GRAY400,
                )
            }
        }
    }
}

@Preview
@Composable
fun GoalReadingChartPreview() {
    GoalReadingChart(
        modifier = Modifier
            .width(312.dp)
            .height(180.dp),
        isHasData = true,
        readingGoalGraphData = listOf(
            ReadingGoalGraphData(1, 3, false, "오"),
            ReadingGoalGraphData(2, 3, true, "늘"),
            ReadingGoalGraphData(1, 3, false, "오"),
            ReadingGoalGraphData(3, 3, false, "오"),
            ReadingGoalGraphData(1, 3, false, "오"),
            ReadingGoalGraphData(3, 3, false, "오"),
            ReadingGoalGraphData(1, 3, false, "오"),
        )
    )
}