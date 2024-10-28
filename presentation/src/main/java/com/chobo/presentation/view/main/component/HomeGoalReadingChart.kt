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
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.domain.model.goal.response.GetWeekendGoalModel
import com.chobo.presentation.view.component.icon.ChevronRightIcon
import com.chobo.presentation.view.component.modifier.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.view.theme.color.MindWayColor
import com.chobo.presentation.viewModel.util.getTodayDayOfWeek
import okhttp3.internal.immutableListOf

@Stable
@Composable
fun HomeGoalReadingChart(
    modifier: Modifier = Modifier,
    isHasData: Boolean = false,
    isLoading: Boolean = false,
    getWeekendGoalModel: GetWeekendGoalModel = GetWeekendGoalModel(0, 0, 0, 0, 0, 0, 0, 0, 0),
    onClick: () -> Unit,
) {
    val weekList = remember { immutableListOf("월", "화", "수", "목", "금", "토", "일") }
    val dateList =
        immutableListOf(
            getWeekendGoalModel.mon,
            getWeekendGoalModel.tue,
            getWeekendGoalModel.wed,
            getWeekendGoalModel.thu,
            getWeekendGoalModel.fri,
            getWeekendGoalModel.sat,
            getWeekendGoalModel.sun
        )
    val currentDate = remember { getTodayDayOfWeek() }

    MindWayAndroidTheme { colors, typography ->
        if (isHasData || !isLoading) {
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
                        ChevronRightIcon(
                            modifier = Modifier.clickableSingle(onClick = onClick),
                            tint = MindWayColor.GRAY400,
                        )
                    }
                    GoalReadingIndicator(
                        numBooksRead = getWeekendGoalModel.now_count,
                        goalBookRead = getWeekendGoalModel.goal_value,
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
                            maxBooksRead = dateList.max(),
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
                    ChevronRightIcon(modifier = Modifier.clickableSingle(onClick = onClick))
                }
                Text(
                    text = if (!isLoading) "아직 목표 독서량을 설정하지 않았습니다."
                    else "로딩중 ..",
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
        isLoading = false,
        getWeekendGoalModel = GetWeekendGoalModel(
            mon = 2,
            tue = 4,
            wed = 6,
            thu = 1,
            fri = 4,
            sat = 4,
            sun = 4,
            now_count = 23,
            goal_value = 30
        )
    )
}