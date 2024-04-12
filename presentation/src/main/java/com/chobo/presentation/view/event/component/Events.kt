package com.chobo.presentation.view.event.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.component.icon.ChevronRightIcon
import com.chobo.presentation.view.theme.MindWayAndroidTheme

data class EventsData(val title: String, val content: String, val date: String)

@Composable
fun Events(
    modifier: Modifier = Modifier,
    eventsData: EventsData,
    onClick: () -> Unit,
    navigateToDetailEvent: () -> Unit
) {
    MindWayAndroidTheme { colors, typography ->
        Spacer(modifier = modifier.height(20.dp))
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .shadow(elevation = 20.dp, spotColor = colors.CardShadow),
            color = colors.WHITE,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .background(
                        color = colors.WHITE,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(
                        horizontal = 24.dp,
                        vertical = 20.dp
                    )
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = eventsData.title,
                        style = typography.bodySmall,
                        color = colors.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = modifier.weight(1f))
                    ChevronRightIcon(
                        modifier = Modifier.clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null
                        ) {
                            onClick()
                            navigateToDetailEvent()
                        }
                    )
                }
                Spacer(modifier = modifier.height(8.dp))
                Text(
                    text = eventsData.content,
                    style = typography.bodySmall,
                    color = colors.GRAY800,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = modifier.height(8.dp))
                Text(
                    text = eventsData.date,
                    style = typography.labelLarge,
                    color = colors.GRAY400,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Preview
@Composable
fun EventsPre() {
    Events(
        eventsData = EventsData(
            title = "가을 독서 행사",
            content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
            date = "2024년 04월 08일"
        ),
        onClick = { },
        navigateToDetailEvent = { },
    )
}