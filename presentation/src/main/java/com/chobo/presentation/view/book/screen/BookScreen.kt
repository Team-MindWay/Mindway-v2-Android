package com.chobo.presentation.view.book.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.book.component.BookListItem
import com.chobo.presentation.view.book.component.BookListItemData
import com.chobo.presentation.view.book.component.BookTabRowItem
import com.chobo.presentation.view.component.icon.PlusIcon
import com.chobo.presentation.view.main.screen.MockOnClick
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BookScreen(
    plusIconOnClick: () -> Unit,
    novelDataList: List<BookListItemData> = listOf(),
    essayDataList: List<BookListItemData> = listOf(),
    novelOnClick: () -> Unit,
    essayOnClick: () -> Unit,
) {
    val pagerState = rememberPagerState(pageCount = { 2 })
    val indexState by remember { mutableIntStateOf(pagerState.currentPage) }
    val tabNames = listOf(
        stringResource(R.string.novel),
        stringResource(R.string.essay),
    )
    val coroutineScope = rememberCoroutineScope()

    MindWayAndroidTheme { colors, _ ->
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 24.dp, top = 20.dp, end = 24.dp)
                    .fillMaxWidth()
            ) {
                TabRow(
                    modifier = Modifier.width(166.dp),
                    selectedTabIndex = pagerState.currentPage,
                    backgroundColor = colors.WHITE,
                    contentColor = colors.MAIN,
                ) {
                    tabNames.forEachIndexed { index, tabName ->
                        BookTabRowItem(
                            indexState = indexState,
                            index = index,
                            tabName = tabName,
                            onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } }
                        )
                    }
                }
                PlusIcon(modifier = Modifier.clickable { plusIconOnClick() }, tint = colors.Black)
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
                            items(novelDataList) {
                                BookListItem(data = it, onClick = novelOnClick)
                            }
                        }

                        1 -> {
                            items(essayDataList) {
                                BookListItem(data = it, onClick = essayOnClick)
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
    BookScreen(
        novelDataList = listOf(
            BookListItemData(writer = "작가이름", title = "제옴ㄹ","내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"),
            BookListItemData(writer = "작가이름", title = "제옴ㄹ","내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"),
            BookListItemData(writer = "작가이름", title = "제옴ㄹ","내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"),BookListItemData(writer = "작가이름", title = "제옴ㄹ","내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"),
            BookListItemData(writer = "작가이름", title = "제옴ㄹ","내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"),
            BookListItemData(writer = "작가이름", title = "제옴ㄹ","내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"),
            BookListItemData(writer = "작가이름", title = "제옴ㄹ","내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"),
            BookListItemData(writer = "작가이름", title = "제옴ㄹ","내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"),
        ),
        essayDataList = listOf(
            BookListItemData(writer = "ds", title = "제옴ㄹ","dsadsadsasad"),
            BookListItemData(writer = "a", title = "제옴ㄹ","내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"),
            BookListItemData(writer = "cx", title = "제옴ㄹ","내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"),BookListItemData(writer = "작가이름", title = "제옴ㄹ","내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"),
            BookListItemData(writer = "v", title = "제옴ㄹ","dasdasd"),
            BookListItemData(writer = "vza", title = "제옴ㄹ","fdsfds"),
            BookListItemData(writer = "dsa", title = "제옴ㄹ","내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"),
            BookListItemData(writer = "gw", title = "제옴ㄹ","czxczxc"),
        ),
        plusIconOnClick = { MockOnClick() },
        novelOnClick = { MockOnClick() },
        essayOnClick = { MockOnClick() },
    )
}
