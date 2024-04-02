package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun GoalReadingChart(
    modifier: Modifier = Modifier,
    isHasData: Boolean,
    numBooksRead: Int,
    readNumberList: List<ReadingGoalGraphData> = listOf(),
) {
    MindWayAndroidTheme { colors, typography ->
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
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
                    numBooksRead = numBooksRead,
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
                    readNumberList.forEach {
                        GoalReadingGraph(
                            numBooksRead = it.numBooksRead,
                            maxBooksRead = it.maxBooksRead,
                            isCurrentDate = it.isCurrentDate,
                            today = it.today,
                            modifier = Modifier
                                .fillMaxWidth(0.0667f)
                                .height(78.dp),
                        )
                    }
                }
            } else {
                Text(
                    text = stringResource(R.string.goal_reading_error),

                    style = typography.bodySmall,
                    fontWeight = FontWeight(400),
                    color = colors.GRAY400,
                )
            }
        }
    }
}