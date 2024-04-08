package com.chobo.presentation.view.event.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.event.screen.OngoingEvent
import com.chobo.presentation.view.event.screen.PastEvent
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EventPager(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    tabs: List<String>,
    onGoingEvent: @Composable (ColumnScope.() -> Unit),
    pastEvent: @Composable (ColumnScope.() -> Unit)
) {

    val coroutineScope = rememberCoroutineScope()

    MindWayAndroidTheme { colors, _ ->
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        modifier = modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                        color = colors.MAIN,
                    )
                },
                divider = {},
                containerColor = colors.WHITE,
                contentColor = colors.GRAY400,
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        text = {
                            Text(
                                title,
                                color = if (pagerState.currentPage == index) colors.Black else colors.GRAY400
                            )
                        },
                        selected = pagerState.currentPage == index,
                        modifier = modifier
                            .fillMaxWidth()
                            .weight(1f),
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }
                    )
                }
            }

            HorizontalPager(
                state = pagerState
            ) { page ->
                when (page) {
                    0 -> onGoingEvent()
                    1 -> pastEvent()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun EventPagerPre() {
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
        onGoingEvent = { },
        pastEvent = { }
    )
}