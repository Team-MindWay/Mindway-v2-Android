@file:OptIn(ExperimentalFoundationApi::class)

package com.chobo.presentation.view.event.screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chobo.domain.emumtype.EventRequestListStatusType.NOW
import com.chobo.domain.emumtype.EventRequestListStatusType.PAST
import com.chobo.presentation.R
import com.chobo.presentation.view.event.component.EventContent
import com.chobo.presentation.view.event.component.EventPager
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.event.EventViewModel
import com.chobo.presentation.viewModel.event.uistate.GetEventListUiState
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay

@Composable
internal fun EventScreenRoute(
    modifier: Modifier = Modifier,
    eventViewModel: EventViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    navigateToDetailEvent: (Long) -> Unit,
) {
    val getEventNowListUiState by eventViewModel.getNowEventListUiState.collectAsStateWithLifecycle()
    val getEventPastListUiState by eventViewModel.getPastEventListUiState.collectAsStateWithLifecycle()
    val (swipeRefreshLoading, setSwipeRefreshLoading) = remember { mutableStateOf(false) }
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = swipeRefreshLoading)

    EventScreen(
        modifier = modifier,
        navigateToDetailEvent = navigateToDetailEvent,
        getEventNowListUiState = getEventNowListUiState,
        getEventPastListUiState = getEventPastListUiState,
        swipeRefreshState = swipeRefreshState,
        setSwipeRefreshLoading = { setSwipeRefreshLoading(true) },
        getEventNowList = { eventViewModel.getEventList(NOW) },
        getEventPastList = { eventViewModel.getEventList(PAST) },
    )

    LaunchedEffect(swipeRefreshLoading) {
        delay(1000)
        setSwipeRefreshLoading(false)
    }

    LaunchedEffect(Unit) {
        eventViewModel.getEventList(NOW)
        eventViewModel.getEventList(PAST)
    }
}

@Composable
internal fun EventScreen(
    modifier: Modifier = Modifier,
    pagerState: PagerState = rememberPagerState { 2 },
    getEventNowListUiState: GetEventListUiState,
    getEventPastListUiState: GetEventListUiState,
    swipeRefreshState: SwipeRefreshState,
    setSwipeRefreshLoading: () -> Unit,
    navigateToDetailEvent: (Long) -> Unit,
    getEventNowList: () -> Unit,
    getEventPastList: () -> Unit,
) {
    MindWayAndroidTheme { colors, _ ->
        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = {
                setSwipeRefreshLoading()
                when (pagerState.currentPage) {
                    1 -> getEventNowList()
                    2 -> getEventPastList()
                }
            }
        ) {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = colors.WHITE)
            ) {
                EventPager(
                    pagerState = pagerState,
                    onGoingEvent = {
                        when (getEventNowListUiState) {
                            GetEventListUiState.Empty -> {
                                EventContent(
                                    content = stringResource(R.string.is_no_ongoing_event),
                                    eventDataListIsEmpty = false,
                                    navigateToDetailEvent = navigateToDetailEvent,
                                )
                            }

                            is GetEventListUiState.Fail -> {
                                EventContent(
                                    content = stringResource(R.string.is_on_error),
                                    eventDataListIsEmpty = false,
                                    navigateToDetailEvent = navigateToDetailEvent,
                                )
                            }

                            is GetEventListUiState.Loading -> {
                                EventContent(
                                    content = stringResource(R.string.is_no_ongoing_event),
                                    eventDataListIsEmpty = true,
                                    navigateToDetailEvent = navigateToDetailEvent,
                                    isLoading = true
                                )
                            }

                            is GetEventListUiState.Success -> {
                                EventContent(
                                    content = stringResource(R.string.is_no_ongoing_event),
                                    eventDataList = getEventNowListUiState.data,
                                    eventDataListIsEmpty = true,
                                    navigateToDetailEvent = navigateToDetailEvent,
                                )
                            }
                        }
                    },
                    pastEvent = {
                        when (getEventPastListUiState) {
                            GetEventListUiState.Empty -> {
                                EventContent(
                                    content = stringResource(R.string.is_no_past_event),
                                    eventDataListIsEmpty = false,
                                    navigateToDetailEvent = navigateToDetailEvent
                                )
                            }

                            is GetEventListUiState.Fail -> {
                                EventContent(
                                    content = stringResource(R.string.is_on_error),
                                    eventDataListIsEmpty = false,
                                    navigateToDetailEvent = navigateToDetailEvent,
                                )
                            }

                            is GetEventListUiState.Loading -> {
                                EventContent(
                                    content = stringResource(R.string.is_no_past_event),
                                    eventDataListIsEmpty = true,
                                    navigateToDetailEvent = navigateToDetailEvent,
                                    isLoading = true
                                )
                            }

                            is GetEventListUiState.Success -> {
                                EventContent(
                                    content = stringResource(R.string.is_no_past_event),
                                    eventDataList = getEventPastListUiState.data,
                                    eventDataListIsEmpty = true,
                                    navigateToDetailEvent = navigateToDetailEvent,
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun EventScreenPre() {
    EventScreen(
        navigateToDetailEvent = { },
        getEventPastList = { },
        getEventNowList = { },
        getEventNowListUiState = GetEventListUiState.Loading,
        swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false),
        getEventPastListUiState = GetEventListUiState.Loading,
        setSwipeRefreshLoading = { }
    )
}