package com.chobo.presentation.view.event.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.component.icon.BookIcon
import com.chobo.presentation.view.component.icon.BookImage
import com.chobo.presentation.view.event.component.EventPager
import com.chobo.presentation.view.event.component.Events
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EventScreen(
    modifier: Modifier = Modifier
) {
    val tabs = listOf(
        stringResource(id = R.string.ongoing_event),
        stringResource(id = R.string.past_event)
    )
    val pagerState = rememberPagerState {
        tabs.size
    }
    EventPager(
        pagerState = pagerState,
        tabs = tabs,
        onGoingEvent = { OngoingEvent() },
        pastEvent = { PastEvent() }
    )
}

@Composable
fun OngoingEvent(
    modifier: Modifier = Modifier
) {
    MindWayAndroidTheme { colors, _ ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(color = colors.WHITE)
                .padding(horizontal = 24.dp)
        ) {
            items(10) {
                Events(
                    title = "가을 독서 행사",
                    content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는",
                    date = "2024년 04월 08일"
                )
            }
        }
    }
}

@Composable
fun PastEvent(
    modifier: Modifier = Modifier
) {
    MindWayAndroidTheme { colors, _ ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(color = colors.WHITE)
                .padding(horizontal = 24.dp)
        ) {
            items(10) {
                Events(
                    title = "가을 독서 행사",
                    content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는",
                    date = "2024년 04월 08일"
                )
            }
        }
    }
}

@Composable
fun NotEvent(
    modifier: Modifier = Modifier,
    content: String
) {
    MindWayAndroidTheme { colors, typography ->
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

@Preview
@Composable
fun EventScreenPre() {
    EventScreen()
}