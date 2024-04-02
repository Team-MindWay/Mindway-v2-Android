package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.theme.MindWayAndroidTheme


data class MonthDay(
    val month: Int,
    val day: Int,
)
@Composable
fun GoalReadingListOfBooksRead(
    date: MonthDay,
    title: String,
    content: String,
) {
    MindWayAndroidTheme { colors, typography ->
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
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
                    text = title,
                    style = typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = colors.Black,
                )
                Text(
                    text = stringResource(
                        R.string.month_day,
                        date.month,
                        date.day
                    ),
                    style = typography.labelLarge,
                    fontWeight = FontWeight.Normal,
                    color = colors.GRAY400,
                )
            }
            Text(
                text = content,
                style = typography.bodySmall,
                fontWeight = FontWeight.Normal,
                color = colors.Black,
            )
        }
    }
}