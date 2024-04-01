package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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


data class HomeReadingGoalGraphData(
    val numBooksRead: Int,
    val maxBooksRead: Int,
    val isCurrentDate: Boolean,
    val today: String,
)

@Composable
fun HomeGoalReadingChart(
    isHasData: Boolean,
    numBooksRead: Int,
    readNumberList: List<HomeReadingGoalGraphData>,
) {
    MindWayAndroidTheme { colors, typography ->
        if (isHasData) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .shadow(
                        elevation = 20.dp,
                        spotColor = colors.GRAY400,
                        ambientColor = colors.GRAY400
                    )
                    .fillMaxWidth()
                    .background(color = colors.WHITE, shape = RoundedCornerShape(size = 8.dp))
                    .padding(24.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.Start),
                    verticalAlignment = Alignment.Top,
                ) {
                    Text(
                        text = "목표 독서량",
                        style = typography.bodyMedium,
                        fontWeight = FontWeight(600),
                        color = colors.Black,
                    )
                    ChevronRightIcon(modifier = Modifier.clickable { })
                }
                HomeGoalReadingIndicator(
                    numBooksRead = numBooksRead,
                    modifier = Modifier
                        .width(264.dp)
                        .height(30.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .width(240.dp)
                        .height(78.dp)
                ) {
                    readNumberList.forEach {
                        HomeGoalReadingGraph(
                            modifier = Modifier.width(16.dp).height(78.dp),
                            numBooksRead = it.numBooksRead,
                            maxBooksRead = it.maxBooksRead,
                            isCurrentDate = it.isCurrentDate,
                            today = it.today,
                        )
                    }
                }
            }
        } else {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .shadow(
                        elevation = 20.dp,
                        spotColor = colors.GRAY400,
                        ambientColor = colors.GRAY400
                    )
                    .fillMaxWidth()
                    .height(211.dp)
                    .background(color = colors.WHITE, shape = RoundedCornerShape(size = 8.dp))
                    .padding(start = 24.dp, top = 24.dp, end = 24.dp, bottom = 24.dp)
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
                        fontWeight = FontWeight(600),
                        color = colors.Black,
                    )
                    ChevronRightIcon()
                }
                Text(
                    text = "아직 목표 독서량을 설정하지 않았습니다.",
                    style = typography.bodySmall,
                    fontWeight = FontWeight(400),
                    color = colors.GRAY400,
                )
                Spacer(
                    modifier = Modifier
                        .height(27.dp)
                )
            }
        }
    }
}