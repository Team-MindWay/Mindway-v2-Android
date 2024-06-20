package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.domain.model.goal.response.GetWeekendGoalModel
import com.chobo.presentation.R
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.util.getTodayDayOfWeek
import okhttp3.internal.immutableListOf

@Stable
@Composable
fun GoalReadingChart(
    modifier: Modifier = Modifier,
    isHasData: Boolean,
    getWeekendGoalModel: GetWeekendGoalModel = GetWeekendGoalModel(0, 0, 0, 0, 0, 0, 0, 0, 0),
) {
    val weekList = immutableListOf("월", "화", "수", "목", "금", "토", "일")
    val dateList = immutableListOf(
        getWeekendGoalModel.mon,
        getWeekendGoalModel.tue,
        getWeekendGoalModel.wed,
        getWeekendGoalModel.thu,
        getWeekendGoalModel.fri,
        getWeekendGoalModel.sat,
        getWeekendGoalModel.sun
    )
    val maxRead = remember { dateList.max() }
    val currentDate = getTodayDayOfWeek()
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
                    numBooksRead = getWeekendGoalModel.now_count,
                    goalBookRead = getWeekendGoalModel.goal_value,
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
        getWeekendGoalModel = GetWeekendGoalModel(
            mon = 32,
            tue = 43,
            wed = 56,
            thu = 1,
            fri = 24,
            sat = 34,
            sun = 45,
            now_count = 23,
            goal_value = 30
        )
    )
}