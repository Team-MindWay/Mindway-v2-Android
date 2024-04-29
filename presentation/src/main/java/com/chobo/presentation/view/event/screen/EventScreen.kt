package com.chobo.presentation.view.event.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.R
import com.chobo.presentation.view.event.component.EventContent
import com.chobo.presentation.view.event.component.EventPager
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.EventViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EventScreen(
    modifier: Modifier = Modifier,
    navigateToDetailEvent: () -> Unit,
    eventViewModel: EventViewModel = viewModel(),
) {
    val currentEventsDataList by eventViewModel.currentEventsDataList.collectAsState()
    val pastEventsDataList by eventViewModel.pastEventsDataList.collectAsState()

    MindWayAndroidTheme { colors, _ ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(color = colors.WHITE)
        ) {
            EventPager(
                pagerState = rememberPagerState { 2 },
                tabs = listOf(
                    stringResource(id = R.string.ongoing_event),
                    stringResource(id = R.string.past_event)
                ),
                onGoingEvent = {
                    EventContent(
                        content = stringResource(R.string.is_no_ongoing_event),
                        eventDataList = currentEventsDataList,
                        onIconClick = eventViewModel::onCurrentEventClick,
                        navigateToDetailEvent = navigateToDetailEvent
                    )
                },
                pastEvent = {
                    EventContent(
                        content = stringResource(R.string.is_no_past_event),
                        eventDataList = pastEventsDataList,
                        onIconClick = eventViewModel::onPastEventClick,
                        navigateToDetailEvent = navigateToDetailEvent
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun EventScreenPre() {
    EventScreen(navigateToDetailEvent = { })
}