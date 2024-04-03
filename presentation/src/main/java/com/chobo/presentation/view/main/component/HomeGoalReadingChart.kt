package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.component.icon.ChevronRightIcon
import com.chobo.presentation.view.theme.MindWayAndroidTheme


data class ReadingGoalGraphData(
    val numBooksRead: Int,
    val maxBooksRead: Int,
    val isCurrentDate: Boolean,
    val today: String,
)

@Composable
fun HomeGoalReadingChart(
    modifier: Modifier,
    isHasData: Boolean,
    readNumberList: List<ReadingGoalGraphData> = listOf(),
    onClick: () -> Unit,
) {
    MindWayAndroidTheme { colors, typography ->
        if (isHasData) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    16.dp,
                    Alignment.Top
                ),
                modifier = modifier
                    .padding(24.dp)
                    .background(
                        color = colors.WHITE,
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .shadow(
                        elevation = 20.dp,
                        spotColor = colors.GRAY400,
                        ambientColor = colors.GRAY400
                    ),

                ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top,
                ) {
                    Text(
                        text = "목표 독서량",
                        style = typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = colors.Black,
                    )
                    ChevronRightIcon(modifier = Modifier.clickable { onClick() })
                }
                GoalReadingIndicator(
                    numBooksRead = numBooksRead,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.1840f)
                )
                        numBooksRead = readNumberList.sumOf { it.numBooksRead },
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .width(240.dp)
                        .height(78.dp)
                ) {
                    readNumberList.forEach {
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
            }
        } else {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .padding(all = 24.dp)
                    .shadow(
                        elevation = 20.dp,
                        spotColor = colors.GRAY400,
                        ambientColor = colors.GRAY400
                    )
                    .background(
                        color = colors.WHITE,
                        shape = RoundedCornerShape(size = 8.dp)
                    )
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        12.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.Top,
                ) {
                    Text(
                        text = "목표 독서량",
                        style = typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = colors.Black,
                    )
                    ChevronRightIcon()
                }
                Text(
                    text = "아직 목표 독서량을 설정하지 않았습니다.",
                    style = typography.bodySmall,
                    fontWeight = FontWeight.Normal,
                    color = colors.GRAY400,
                )
                Spacer(
                    modifier = Modifier.height(27.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeGoalReadingChartPreview() {
    HomeGoalReadingChart(
        modifier = Modifier
            .width(312.dp)
            .height(211.dp),
        isHasData = true,
        readNumberList = listOf(
            ReadingGoalGraphData(2, 3, false, "일"),
            ReadingGoalGraphData(3, 3, false, "일"),
            ReadingGoalGraphData(2, 3, false, "일"),
            ReadingGoalGraphData(1, 3, true, "일"),
            ReadingGoalGraphData(2, 3, false, "일"),
            ReadingGoalGraphData(1, 3, false, "일"),
            ReadingGoalGraphData(2, 3, false, "일"),
        )
    ) {
    }
}