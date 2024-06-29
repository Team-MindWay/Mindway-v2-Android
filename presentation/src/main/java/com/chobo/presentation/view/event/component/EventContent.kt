package com.chobo.presentation.view.event.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.domain.model.event.response.GetEventListResponseModel
import com.chobo.presentation.view.component.icon.BookImage
import com.chobo.presentation.view.component.shimmer.shimmerEffect
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun EventContent(
    modifier: Modifier = Modifier,
    content: String,
    eventDataListIsEmpty: Boolean,
    eventDataList: List<GetEventListResponseModel> = listOf(),
    navigateToDetailEvent: (Long) -> Unit,
    isLoading: Boolean = false
) {
    MindWayAndroidTheme { colors, typography ->
        if (isLoading) {
            LazyColumn(
                modifier = Modifier
                    .background(
                        color = colors.WHITE,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 24.dp)
                    .fillMaxSize()
            ) {
                items(10) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(136.dp)
                            .padding(vertical = 16.dp)
                            .background(
                                color = colors.WHITE,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .shimmerEffect(shape = RoundedCornerShape(8.dp))
                    )
                }
            }
        } else if (eventDataListIsEmpty) {
            LazyColumn(
                modifier = modifier
                    .background(color = colors.WHITE)
                    .padding(horizontal = 24.dp)
                    .fillMaxSize()
            ) {
                itemsIndexed(eventDataList) { _, item ->
                    Events(
                        eventsData = item,
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
        eventDataListIsEmpty = true,
        navigateToDetailEvent = {},
        isLoading = true
    )
}