package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.domain.model.goal.GoalWeekendResponse
import com.chobo.presentation.view.component.icon.ChevronRightIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.util.getTodayDayOfWeek
import okhttp3.internal.immutableListOf

data class GoalReadingGraphData(
    val numBooksRead: Int,
    val maxBooksRead: Int,
    val isCurrentDate: Boolean,
    val today: String,
)

@Composable
fun HomeGoalReadingChart(
    modifier: Modifier = Modifier,
    isHasData: Boolean,
    goalWeekendResponse: GoalWeekendResponse,
    onClick: () -> Unit,
) {
    val weekList = remember { immutableListOf("월", "화", "수", "목", "금", "토", "일") }
    val dateList = remember {
        mutableListOf(
            goalWeekendResponse.mon,
            goalWeekendResponse.tue,
            goalWeekendResponse.wed,
            goalWeekendResponse.thu,
            goalWeekendResponse.fri,
            goalWeekendResponse.sat,
            goalWeekendResponse.sun
        )
    }
    val maxRead = remember { dateList.max() }
    val currentDate = getTodayDayOfWeek()

    MindWayAndroidTheme { colors, typography ->
        if (isHasData) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
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
                        ChevronRightIcon(modifier = Modifier.clickableSingle(onClick = onClick))
                    }
                    GoalReadingIndicator(
                        numBooksRead = goalWeekendResponse.now_count,
                        goalBookRead = goalWeekendResponse.goal_value,
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
                    weekList.forEachIndexed { index, date ->
                        GoalReadingGraph(
                            numBooksRead = dateList[index],
                            maxBooksRead = maxRead,
                            isCurrentDate = currentDate == date,
                            today = date,
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
                    .shadow(
                        elevation = 20.dp,
                        spotColor = colors.GRAY400,
                        ambientColor = colors.GRAY400
                    )
                    .background(
                        color = colors.WHITE,
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .padding(all = 24.dp)
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
                    ChevronRightIcon()
                }
                Text(
                    text = "아직 목표 독서량을 설정하지 않았습니다.",
                    style = typography.bodySmall,
                    fontWeight = FontWeight.Normal,
                    color = colors.GRAY400,
                )
                Spacer(modifier = Modifier.height(27.dp))
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
        onClick = { },
        goalWeekendResponse = GoalWeekendResponse(
            mon = 32,
            tue = 43,
            wed = 56,
            thu = 1,
            fri = 24,
            sat = 34,
            sun = 45,
            now_count = 23,
            goal_value = 300
        )
    )
}