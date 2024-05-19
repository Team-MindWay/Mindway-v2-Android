package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun GoalReadingChart(
    modifier: Modifier = Modifier,
    goalBookRead: Int,
    isHasData :Boolean = false,
    goalReadingGraphData: List<GoalReadingGraphData> = listOf(),
) {
    MindWayAndroidTheme { colors, typography ->
        Column(
            verticalArrangement = if (isHasData) Arrangement.SpaceBetween else Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
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
                    goalBookRead = goalBookRead,
                    numBooksRead = goalReadingGraphData.sumOf { it.numBooksRead },
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.2419f),
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxWidth(0.9091f)
                        .height(78.dp)
                ) {
                    goalReadingGraphData.forEach {
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
        goalReadingGraphData = listOf(
            GoalReadingGraphData(1, 3, false, "오"),
            GoalReadingGraphData(2, 3, true, "늘"),
            GoalReadingGraphData(1, 3, false, "오"),
            GoalReadingGraphData(3, 3, false, "오"),
            GoalReadingGraphData(1, 3, false, "오"),
            GoalReadingGraphData(3, 3, false, "오"),
            GoalReadingGraphData(1, 3, false, "오"),
        ),
        goalBookRead = 12
    )
}