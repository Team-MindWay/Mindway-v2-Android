package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.component.icon.ChevronRightIcon
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class GoalReadingGraphData(
    val numBooksRead: Int,
    val maxBooksRead: Int,
    val isCurrentDate: Boolean,
    val today: String,
)

@Composable
fun HomeGoalReadingChart(
    modifier: Modifier,
    readNumberList: List<GoalReadingGraphData> = listOf(),
    onClick: () -> Unit,
    goalBookRead: StateFlow<Int>,
) {
    MindWayAndroidTheme { colors, typography ->
        if (readNumberList.isNotEmpty()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                modifier = modifier
                    .shadow(
                        elevation = 20.dp,
                        spotColor = colors.GRAY400,
                        ambientColor = colors.GRAY400
                    )
                    .background(
                        color = colors.WHITE,
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .padding(24.dp),
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "목표 독서량",
                            style = typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = colors.Black,
                        )
                        ChevronRightIcon(
                            modifier = Modifier
                                .clickable(
                                    interactionSource = MutableInteractionSource(),
                                    indication = null
                                ) { onClick() }
                        )
                    }
                    GoalReadingIndicator(
                        numBooksRead = readNumberList.sumOf { it.numBooksRead },
                        goalBookRead = goalBookRead.collectAsState().value,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.1840f)
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxWidth(0.909f)
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
    val _goalBookRead = MutableStateFlow(15)

    HomeGoalReadingChart(
        modifier = Modifier
            .width(312.dp)
            .height(211.dp),
        isHasData = true,
        readNumberList = listOf(
            GoalReadingGraphData(2, 3, false, "일"),
            GoalReadingGraphData(3, 3, false, "일"),
            GoalReadingGraphData(2, 3, false, "일"),
            GoalReadingGraphData(1, 3, true, "일"),
            GoalReadingGraphData(2, 3, false, "일"),
            GoalReadingGraphData(1, 3, false, "일"),
            GoalReadingGraphData(2, 3, false, "일"),
        ),
        onClick = { },
        goalBookRead =_goalBookRead
    )
}