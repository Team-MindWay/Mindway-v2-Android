package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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


data class GoalReadingListOfBooksReadItemData(
    val month: Int,
    val day: Int,
    val title: String,
    val content: String,
)

@Composable
fun GoalReadingListOfBooksReadItem(
    data: GoalReadingListOfBooksReadItemData,
    onClick: () -> Unit,
) {
    MindWayAndroidTheme { colors, typography ->
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .clickable { onClick() }
                .fillMaxWidth()
                .shadow(
                    elevation = 20.dp,
                    spotColor = colors.CardShadow,
                    ambientColor = colors.CardShadow,
                )
                .background(
                    color = colors.WHITE,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .padding(all = 24.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = data.title,
                    style = typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = colors.Black,
                )
                Text(
                    text = stringResource(
                        R.string.month_day,
                        data.month,
                        data.day
                    ),
                    style = typography.labelLarge,
                    fontWeight = FontWeight.Normal,
                    color = colors.GRAY400,
                )
            }
            Text(
                text = data.content,
                style = typography.bodySmall,
                fontWeight = FontWeight.Normal,
                color = colors.Black,
            )
        }
    }
}

@Preview
@Composable
fun GoalReadingListOfBooksReadItemPreview() {
    GoalReadingListOfBooksReadItem(
        data = GoalReadingListOfBooksReadItemData(
            month = 1,
            day = 12,
            title = "제목",
            content = "GoalReadingListOfBooksReadItem GoalReadingListOfBooksReadItemGoalReadingListOfBooksReadItemGoalReadingListOfBooksReadItemGoalReadingListOfBooksReadItemGoalReadingListOfBooksReadItem"
        )
    ) {
    }
}