@file:OptIn(ExperimentalFoundationApi::class)

package com.chobo.presentation.view.book.screen

import androidx.activity.ComponentActivity
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
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chobo.domain.emumtype.OrderRequestBookType
import com.chobo.presentation.R
import com.chobo.presentation.view.book.component.BookListItem
import com.chobo.presentation.view.book.component.BookTabRowItem
import com.chobo.presentation.view.component.customToast.MindWayToast
import com.chobo.presentation.view.component.icon.BookImage
import com.chobo.presentation.view.component.icon.PlusIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.book.BookAddBookViewModel
import com.chobo.presentation.viewModel.book.BookScreenViewModel
import com.chobo.presentation.viewModel.book.uistate.GetRecommendBookUiState
import com.chobo.presentation.viewModel.book.uistate.OrderUploadUiState
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.launch

@Composable
internal fun BookRoute(
    modifier: Modifier = Modifier,
    bookAddBookScreen: BookAddBookViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    bookScreenViewModel: BookScreenViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    navigateToBookAddBook: () -> Unit,
) {
    val novelDataList by bookScreenViewModel.novelDataList.collectAsStateWithLifecycle()
    val essayDataList by bookScreenViewModel.essayDataList.collectAsStateWithLifecycle()
    val isToastVisible by bookScreenViewModel.isToastVisible.collectAsStateWithLifecycle()
    val orderUploadUiState by bookAddBookScreen.orderUploadUiState.collectAsStateWithLifecycle()
    val swipeRefreshLoading by bookScreenViewModel.swipeRefreshLoading.collectAsStateWithLifecycle()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = swipeRefreshLoading)

    BookScreen(
        modifier = modifier,
        isToastVisible = isToastVisible,
        novelDataList = novelDataList,
        essayDataList = essayDataList,
        swipeRefreshState = swipeRefreshState,
        orderUploadUiState = orderUploadUiState,
        getRecommendBook = bookScreenViewModel::getRecommendBook,
        showToast = bookScreenViewModel::showToast,
        navigateToBookAddBook = navigateToBookAddBook,
    )
}

@Composable
internal fun BookScreen(
    modifier: Modifier = Modifier,
    isToastVisible: Boolean,
    novelDataList: GetRecommendBookUiState,
    essayDataList: GetRecommendBookUiState,
    swipeRefreshState: SwipeRefreshState,
    orderUploadUiState: OrderUploadUiState,
    getRecommendBook: (OrderRequestBookType) -> Unit,
    showToast: () -> Unit,
    navigateToBookAddBook: () -> Unit,
) {
    val pagerState = rememberPagerState(pageCount = { 2 })
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    MindWayAndroidTheme { colors, typography ->
        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = {
                getRecommendBook(
                    if (pagerState.currentPage == 1) {
                        OrderRequestBookType.ESSAY
                    } else {
                        OrderRequestBookType.NOVEL
                    }
                )
            }
        ) {
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
                        when (page) {
                            0 -> {
                                when (novelDataList) {
                                    is GetRecommendBookUiState.Loading -> Unit
                                    is GetRecommendBookUiState.Empty -> {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .verticalScroll(scrollState),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Column(
                                                verticalArrangement = Arrangement.spacedBy(
                                                    20.dp,
                                                    Alignment.Top
                                                ),
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                            ) {
                                                BookImage()
                                                Text(
                                                    text = stringResource(R.string.not_book),
                                                    style = typography.bodyMedium,
                                                    fontWeight = FontWeight.Normal,
                                                    color = colors.GRAY500,
                                                )
                                            }
                                        }
                                    }

                                    is GetRecommendBookUiState.Fail -> {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .verticalScroll(scrollState),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Column(
                                                verticalArrangement = Arrangement.spacedBy(
                                                    20.dp,
                                                    Alignment.Top
                                                ),
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                            ) {
                                                BookImage()
                                                Text(
                                                    text = stringResource(R.string.is_on_error),
                                                    style = typography.bodyMedium,
                                                    fontWeight = FontWeight.Normal,
                                                    color = colors.GRAY500,
                                                )
                                            }
                                        }
                                    }

                                    is GetRecommendBookUiState.Success -> {
                                        LazyColumn(
                                            verticalArrangement = Arrangement.spacedBy(
                                                20.dp,
                                                Alignment.Top
                                            ),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            modifier = Modifier
                                                .padding(horizontal = 24.dp)
                                                .fillMaxSize()
                                        ) {
                                            item { Spacer(modifier = Modifier.height(8.dp)) }
                                            itemsIndexed(novelDataList.data) { _, item ->
                                                BookListItem(data = item)
                                            }
                                        }
                                    }
                                }
                            }

                            1 -> {
                                when (essayDataList) {
                                    is GetRecommendBookUiState.Loading -> Unit
                                    is GetRecommendBookUiState.Empty -> {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .verticalScroll(scrollState),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Column(
                                                verticalArrangement = Arrangement.spacedBy(
                                                    20.dp,
                                                    Alignment.Top
                                                ),
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                            ) {
                                                BookImage()
                                                Text(
                                                    text = stringResource(R.string.not_essay),
                                                    style = typography.bodyMedium,
                                                    fontWeight = FontWeight.Normal,
                                                    color = colors.GRAY500,
                                                )
                                            }
                                        }
                                    }

                                    is GetRecommendBookUiState.Fail -> {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .verticalScroll(scrollState),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Column(
                                                verticalArrangement = Arrangement.spacedBy(
                                                    20.dp,
                                                    Alignment.Top
                                                ),
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                            ) {
                                                BookImage()
                                                Text(
                                                    text = stringResource(R.string.is_on_error),
                                                    style = typography.bodyMedium,
                                                    fontWeight = FontWeight.Normal,
                                                    color = colors.GRAY500,
                                                )
                                            }
                                        }
                                    }

                                    is GetRecommendBookUiState.Success -> {
                                        LazyColumn(
                                            verticalArrangement = Arrangement.spacedBy(
                                                20.dp,
                                                Alignment.Top
                                            ),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            modifier = Modifier
                                                .padding(horizontal = 24.dp)
                                                .fillMaxSize()
                                        ) {
                                            item { Spacer(modifier = modifier.height(8.dp)) }
                                            itemsIndexed(essayDataList.data) { _, item ->
                                                BookListItem(data = item)
                                            }
                                        }
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
                    when (orderUploadUiState) {
                        is OrderUploadUiState.Fail -> {
                            showToast()
                            MindWayToast(
                                isSuccess = false,
                                text = stringResource(R.string.book_request_fail_toast),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        is OrderUploadUiState.Loading -> Unit
                        is OrderUploadUiState.RemoteFail -> {
                            showToast()
                            MindWayToast(
                                isSuccess = false,
                                text = stringResource(R.string.book_request_fail_toast),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        is OrderUploadUiState.Success -> {
                            showToast()
                            MindWayToast(
                                isSuccess = true,
                                text = stringResource(R.string.book_request_succes_toast),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookScreenPreview() {
    BookScreen(
        essayDataList = GetRecommendBookUiState.Loading,
        getRecommendBook = { _ -> },
        isToastVisible = false,
        navigateToBookAddBook = {},
        novelDataList = GetRecommendBookUiState.Loading,
        orderUploadUiState = OrderUploadUiState.Loading,
        showToast = {},
        swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)
    )
}
