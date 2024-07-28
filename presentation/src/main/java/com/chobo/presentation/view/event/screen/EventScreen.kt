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
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chobo.domain.emumtype.EventRequestListStatusType
import com.chobo.presentation.R
import com.chobo.presentation.view.event.component.EventContent
import com.chobo.presentation.view.event.component.EventPager
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.event.EventViewModel
import com.chobo.presentation.viewModel.event.uistate.GetNowEventListUiState
import com.chobo.presentation.viewModel.event.uistate.GetPastEventListUiState
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay
import okhttp3.internal.toImmutableList

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

    LaunchedEffect(swipeRefreshLoading) {
        delay(1000)
        setSwipeRefreshLoading(false)
    }

    EventScreen(
        modifier = modifier,
        navigateToDetailEvent = navigateToDetailEvent,
        getEventNowListUiState = getEventNowListUiState,
        getEventPastListUiState = getEventPastListUiState,
        swipeRefreshState = swipeRefreshState,
        setSwipeRefreshLoading = {
            setSwipeRefreshLoading(true)
        },
        getEventNowList = eventViewModel::getEventNowList,
        getEventPastList = eventViewModel::getEventPastList,
    )
}

@Composable
internal fun EventScreen(
    modifier: Modifier = Modifier,
    pagerState: PagerState = rememberPagerState { 2 },
    getEventNowListUiState: GetNowEventListUiState,
    getEventPastListUiState: GetPastEventListUiState,
    swipeRefreshState: SwipeRefreshState,
    setSwipeRefreshLoading: () -> Unit,
    navigateToDetailEvent: (Long) -> Unit,
    getEventNowList: (String) -> Unit,
    getEventPastList: (String) -> Unit,
) {
    val (storageNowStatus, setStorageNowStatus) = remember {
        mutableStateOf(EventRequestListStatusType.NOW)
    }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            when (page) {
                0 -> setStorageNowStatus(EventRequestListStatusType.NOW)
                1 -> setStorageNowStatus(EventRequestListStatusType.PAST)
            }
        }
    }
    LaunchedEffect(Unit) {
        getEventNowList(storageNowStatus.name)
        getEventPastList(EventRequestListStatusType.PAST.name)
    }

    MindWayAndroidTheme { colors, _ ->
        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = {
                setSwipeRefreshLoading()
                when (storageNowStatus) {
                    EventRequestListStatusType.NOW -> getEventNowList(storageNowStatus.name)
                    EventRequestListStatusType.PAST -> getEventPastList(EventRequestListStatusType.PAST.name)
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
                            GetNowEventListUiState.Empty -> {
                                EventContent(
                                    content = stringResource(R.string.is_no_ongoing_event),
                                    eventDataListIsEmpty = false,
                                    navigateToDetailEvent = navigateToDetailEvent,
                                )
                            }

                            is GetNowEventListUiState.Fail -> {
                                EventContent(
                                    content = stringResource(R.string.is_on_error),
                                    eventDataListIsEmpty = false,
                                    navigateToDetailEvent = navigateToDetailEvent,
                                )
                            }

                            is GetNowEventListUiState.Loading -> {
                                EventContent(
                                    content = stringResource(R.string.is_no_ongoing_event),
                                    eventDataListIsEmpty = true,
                                    navigateToDetailEvent = navigateToDetailEvent,
                                    isLoading = true
                                )
                            }

                            is GetNowEventListUiState.Success -> {
                                EventContent(
                                    content = stringResource(R.string.is_no_ongoing_event),
                                    eventDataList = getEventNowListUiState.getEventListResponse.toImmutableList(),
                                    eventDataListIsEmpty = true,
                                    navigateToDetailEvent = navigateToDetailEvent,
                                )
                            }
                        }
                    },
                    pastEvent = {
                        when (getEventPastListUiState) {
                            GetPastEventListUiState.Empty -> {
                                EventContent(
                                    content = stringResource(R.string.is_no_past_event),
                                    eventDataListIsEmpty = false,
                                    navigateToDetailEvent = navigateToDetailEvent
                                )
                            }

                            is GetPastEventListUiState.Fail -> {
                                EventContent(
                                    content = stringResource(R.string.is_on_error),
                                    eventDataListIsEmpty = false,
                                    navigateToDetailEvent = navigateToDetailEvent,
                                )
                            }

                            is GetPastEventListUiState.Loading -> {
                                EventContent(
                                    content = stringResource(R.string.is_no_past_event),
                                    eventDataListIsEmpty = true,
                                    navigateToDetailEvent = navigateToDetailEvent,
                                    isLoading = true
                                )
                            }

                            is GetPastEventListUiState.Success -> {
                                EventContent(
                                    content = stringResource(R.string.is_no_past_event),
                                    eventDataList = getEventPastListUiState.getEventListResponse.toImmutableList(),
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
        getEventPastList = { _ -> },
        getEventNowList = { _ -> },
        getEventNowListUiState = GetNowEventListUiState.Loading,
        swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false),
        getEventPastListUiState = GetPastEventListUiState.Loading,
        setSwipeRefreshLoading = { }
    )
}