package com.chobo.presentation.view.event.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.TabRowDefaults
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
import com.chobo.presentation.R
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EventPager(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    onGoingEvent: @Composable (ColumnScope.() -> Unit),
    pastEvent: @Composable (ColumnScope.() -> Unit)
) {
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
                listOf(
                    stringResource(id = R.string.ongoing_event),
                    stringResource(id = R.string.past_event)
                ).forEachIndexed { index, title ->
                    Tab(
                        text = {
                            Text(
                                text = title,
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
    val pagerState = rememberPagerState {
        2
    }
    EventPager(
        pagerState = pagerState,
        onGoingEvent = { },
        pastEvent = { }
    )
}