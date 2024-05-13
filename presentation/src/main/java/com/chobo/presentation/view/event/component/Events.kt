package com.chobo.presentation.view.event.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.component.icon.ChevronRightIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
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
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .shadow(elevation = 20.dp, spotColor = colors.CardShadow),
            color = colors.WHITE,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
                    .fillMaxWidth()
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
                        modifier = Modifier.clickableSingle {
                            onClick()
                            navigateToDetailEvent()
                        }
                    )
                }
                Text(
                    text = eventsData.content,
                    style = typography.bodySmall,
                    color = colors.GRAY800,
                    fontWeight = FontWeight.Normal
                )
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