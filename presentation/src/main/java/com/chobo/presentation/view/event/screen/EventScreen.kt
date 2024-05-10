package com.chobo.presentation.view.event.screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.R
import com.chobo.presentation.view.event.component.EventContent
import com.chobo.presentation.view.event.component.EventPager
import com.chobo.presentation.view.event.component.EventsData
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.event.EventViewModel
import com.chobo.presentation.viewModel.event.uistate.GetDetailEventUiState
import com.chobo.presentation.viewModel.event.uistate.GetEventDateListUiState
import com.chobo.presentation.viewModel.event.uistate.GetEventListUiState

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun EventScreenRoute(
    modifier: Modifier = Modifier,
    navigateToDetailEvent: () -> Unit,
    eventViewModel: EventViewModel = viewModel(LocalContext.current as ComponentActivity)
) {
    val getEventListUiState by eventViewModel.getEventListUiState.collectAsStateWithLifecycle()
    val getDetailEventUiState by eventViewModel.getDetailEventUiState.collectAsStateWithLifecycle()
    val getEventDateListUiState by eventViewModel.getEventDateListUiState.collectAsStateWithLifecycle()
    val pastEventsDataList by eventViewModel.pastEventsDataList.collectAsStateWithLifecycle()
    val currentEventsDataList by eventViewModel.currentEventsDataList.collectAsStateWithLifecycle()
    val pagerState = rememberPagerState { 2 }

    EventScreen(
        modifier = modifier,
        navigateToDetailEvent = navigateToDetailEvent,
        getEventListUiState = getEventListUiState,
        getDetailEventUiState = getDetailEventUiState,
        getEventDateListUiState = getEventDateListUiState,
        pastEventsDataList = pastEventsDataList,
        currentEventsDataList = currentEventsDataList,
        pagerState = pagerState,
        onCurrentEventClick = eventViewModel::onCurrentEventClick,
        onPastEventClick = eventViewModel::onPastEventClick,
        mainCallBack = { }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun EventScreen(
    modifier: Modifier = Modifier,
    getEventListUiState: GetEventListUiState,
    getDetailEventUiState: GetDetailEventUiState,
    getEventDateListUiState: GetEventDateListUiState,
    pastEventsDataList: List<EventsData>,
    currentEventsDataList: List<EventsData>,
    pagerState: PagerState,
    mainCallBack: () -> Unit,
    onCurrentEventClick: (Int) -> Unit,
    onPastEventClick: (Int) -> Unit,
    navigateToDetailEvent: () -> Unit,
) {
    MindWayAndroidTheme { colors, _ ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(color = colors.WHITE)
        ) {
            EventPager(
                pagerState = pagerState,
                tabs = listOf(
                    stringResource(id = R.string.ongoing_event),
                    stringResource(id = R.string.past_event)
                ),
                onGoingEvent = {
                    EventContent(
                        content = stringResource(R.string.is_no_ongoing_event),
                        eventDataList = currentEventsDataList,
                        eventDataListIsEmpty = currentEventsDataList.isEmpty(),
                        onIconClick = onCurrentEventClick,
                        navigateToDetailEvent = navigateToDetailEvent,
                    )
                },
                pastEvent = {
                    EventContent(
                        content = stringResource(R.string.is_no_past_event),
                        eventDataList = pastEventsDataList,
                        eventDataListIsEmpty = pastEventsDataList.isEmpty(),
                        onIconClick = onPastEventClick,
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
    EventScreenRoute(navigateToDetailEvent = { })
}