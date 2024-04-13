package com.chobo.presentation.view.book.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.R
import com.chobo.presentation.view.book.component.BookListItem
import com.chobo.presentation.view.book.component.BookTabRowItem
import com.chobo.presentation.view.component.icon.PlusIcon
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.BookScreenViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BookScreen(
    modifier: Modifier = Modifier,
    bookViewModel: BookScreenViewModel = viewModel(),
) {
    val pagerState = rememberPagerState(pageCount = { 2 })
    val tabNames = listOf(
        stringResource(R.string.novel),
        stringResource(R.string.essay),
    )
    val coroutineScope = rememberCoroutineScope()

    MindWayAndroidTheme { colors, _ ->
        Column(modifier = modifier.background(color = colors.WHITE)) {
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
                    modifier = Modifier.width(166.dp),
                    selectedTabIndex = pagerState.currentPage,
                    contentColor = colors.MAIN,
                    backgroundColor = colors.WHITE
                ) {
                    tabNames.forEachIndexed { index, tabName ->
                        BookTabRowItem(
                            indexState = pagerState.currentPage,
                            index = index,
                            tabName = tabName,
                            onClick = {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(
                                        index
                                    )
                                }
                            }
                        )
                    }
                }
                PlusIcon(
                    modifier = Modifier.clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null
                    ) { bookViewModel.plusIconOnClick() },
                    tint = colors.Black
                )
            }
            HorizontalPager(state = pagerState) { page ->
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .padding(
                            horizontal = 24.dp,
                            vertical = 28.dp,
                        )
                        .fillMaxSize()
                ) {
                    when (page) {
                        0 -> {
                            itemsIndexed(bookViewModel.novelDataList) { index, item ->
                                BookListItem(data = item)
                            }
                        }

                        1 -> {
                            itemsIndexed(bookViewModel.essayDataList) { index, item ->
                                BookListItem(data = item)
                            }
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
    BookScreen()
}
