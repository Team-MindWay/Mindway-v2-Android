package com.chobo.presentation.view.event.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.domain.model.event.response.GetEventListResponseModel
import com.chobo.presentation.view.component.icon.BookImage
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun EventContent(
    modifier: Modifier = Modifier,
    content: String,
    eventDataList: List<GetEventListResponseModel> = listOf(),
    eventDataListIsEmpty: Boolean,
    onIconClick: (Int) -> Unit,
    onEventClick: (Long) -> Unit,
    navigateToDetailEvent: () -> Unit,
) {
    MindWayAndroidTheme { colors, typography ->
        if (eventDataListIsEmpty) {
            LazyColumn(
                modifier = modifier
                    .background(color = colors.WHITE)
                    .padding(horizontal = 24.dp)
            ) {
                itemsIndexed(eventDataList) { index, item ->
                    Events(
                        eventsData = item,
                        onClick = {
                            onIconClick(index)
                            onEventClick(item.id)
                        },
                        navigateToDetailEvent = navigateToDetailEvent
                    )
                }
            }
        } else {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(colors.WHITE),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                BookImage()
                Spacer(modifier = modifier.height(20.dp))
                Text(
                    text = content,
                    style = typography.bodyMedium,
                    color = colors.GRAY500,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Preview
@Composable
fun EventContentPreview() {
    EventContent(
        content = "리뷰 정말 감사합니다 임시 데이터 입니다",
        onIconClick = {},
        eventDataListIsEmpty = true,
        navigateToDetailEvent = {},
        onEventClick = {}
    )
}