@file:OptIn(ExperimentalFoundationApi::class)

package com.chobo.presentation.view.book.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chobo.domain.model.recommend.response.RecommendListResponseAllModel
import com.chobo.presentation.R
import com.chobo.presentation.view.book.component.BookListItem
import com.chobo.presentation.view.book.component.BookTabRowItem
import com.chobo.presentation.view.component.customToast.MindWayToast
import com.chobo.presentation.view.component.icon.PlusIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.book.BookScreenViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
internal fun BookRoute(
    modifier: Modifier = Modifier,
    bookScreenViewModel: BookScreenViewModel = hiltViewModel(),
    navigateToBookAddBook: () -> Unit,
) {
    val novelDataList by bookScreenViewModel.novelDataList.collectAsStateWithLifecycle()
    val essayDataList by bookScreenViewModel.essayDataList.collectAsStateWithLifecycle()
    val isToastVisible by bookScreenViewModel.isToastVisible.collectAsStateWithLifecycle()
    val pagerState = rememberPagerState(pageCount = { 2 })
    val coroutineScope = rememberCoroutineScope()

    BookScreen(
        modifier = modifier,
        novelDataList = novelDataList,
        essayDataList = essayDataList,
        isToastVisible = isToastVisible,
        pagerState = pagerState,
        coroutineScope = coroutineScope,
        navigateToBookAddBook = navigateToBookAddBook
    )
}

@Composable
internal fun BookScreen(
    modifier: Modifier = Modifier,
    novelDataList: List<RecommendListResponseAllModel>,
    essayDataList: List<RecommendListResponseAllModel>,
    isToastVisible: Boolean,
    pagerState: PagerState,
    coroutineScope: CoroutineScope,
    navigateToBookAddBook: () -> Unit,
) {
    MindWayAndroidTheme { colors, _ ->
        Box(modifier = modifier.background(color = colors.WHITE)) {
            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(
                            start = 24.dp,
                            top = 20.dp,
                            end = 24.dp
                        )
                        .fillMaxWidth()
                ) {
                    TabRow(
                        selectedTabIndex = pagerState.currentPage,
                        contentColor = colors.MAIN,
                        backgroundColor = colors.WHITE,
                        modifier = Modifier.width(166.dp),
                    ) {
                        listOf(
                            stringResource(R.string.novel),
                            stringResource(R.string.essay),
                        ).forEachIndexed { index, tabName ->
                            BookTabRowItem(
                                isCurrentIndex = index == pagerState.currentPage,
                                tabName = tabName,
                                onClick = {
                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(index)
                                    }
                                }
                            )
                        }
                    }
                    PlusIcon(
                        tint = colors.Black,
                        modifier = Modifier.clickableSingle(onClick = navigateToBookAddBook),
                    )
                }
                HorizontalPager(state = pagerState) { page ->
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .fillMaxSize()
                    ) {
                        when (page) {
                            0 -> {
                                item { Spacer(modifier = modifier.height(28.dp)) }
                                itemsIndexed(novelDataList) { _, item ->
                                    BookListItem(data = item)
                                }
                            }

                            1 -> {
                                item { Spacer(modifier = modifier.height(28.dp)) }
                                itemsIndexed(essayDataList) { _, item ->
                                    BookListItem(data = item)
                                }
                            }
                        }
                    }
                }
            }
            AnimatedVisibility(
                visible = isToastVisible,
                enter = slideInVertically(
                    initialOffsetY = { it + 55 },
                    animationSpec = tween(durationMillis = 500)
                ),
                exit = slideOutVertically(
                    targetOffsetY = { it + 55 },
                    animationSpec = tween(durationMillis = 500)
                ),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = -(20).dp)
                    .padding(horizontal = 24.dp),
            ) {
                MindWayToast(
                    isSuccess = true,
                    text = stringResource(R.string.book_request_succes_toast),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookScreenPreview() {
    BookRoute { }
}
