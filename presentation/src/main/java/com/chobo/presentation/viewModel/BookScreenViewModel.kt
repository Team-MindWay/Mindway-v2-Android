package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.chobo.presentation.view.book.component.BookListItemData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class BookScreenViewModel @Inject constructor() : ViewModel() {
    private val _novelDataList = MutableStateFlow(
        listOf(
            BookListItemData(
                writer = "작가이름",
                title = "제옴ㄹ",
                "내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"
            ),
            BookListItemData(
                writer = "작가이름",
                title = "제옴ㄹ",
                "내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"
            ),
            BookListItemData(
                writer = "작가이름",
                title = "제옴ㄹ",
                "내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"
            ),
            BookListItemData(
                writer = "작가이름",
                title = "제옴ㄹ",
                "내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"
            ),
            BookListItemData(
                writer = "작가이름",
                title = "제옴ㄹ",
                "내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"
            ),
            BookListItemData(
                writer = "작가이름",
                title = "제옴ㄹ",
                "내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"
            ),
            BookListItemData(
                writer = "작가이름",
                title = "제옴ㄹ",
                "내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"
            ),
            BookListItemData(
                writer = "작가이름",
                title = "제옴ㄹ",
                "내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"
            ),
        )
    )
    val novelDataList: StateFlow<List<BookListItemData>> = _novelDataList.asStateFlow()

    private val _essayDataList = MutableStateFlow(
        listOf(
            BookListItemData(writer = "ds", title = "제옴ㄹ", "dsadsadsasad"),
            BookListItemData(
                writer = "a",
                title = "제옴ㄹ",
                "내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"
            ),
            BookListItemData(
                writer = "cx",
                title = "제옴ㄹ",
                "내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"
            ),
            BookListItemData(
                writer = "작가이름",
                title = "제옴ㄹ",
                "내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"
            ),
            BookListItemData(writer = "v", title = "제옴ㄹ", "dasdasd"),
            BookListItemData(writer = "vza", title = "제옴ㄹ", "fdsfds"),
            BookListItemData(
                writer = "dsa",
                title = "제옴ㄹ",
                "내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"
            ),
            BookListItemData(writer = "gw", title = "제옴ㄹ", "czxczxc"),
        )
    )
    val essayDataList: StateFlow<List<BookListItemData>> = _essayDataList.asStateFlow()

    fun plusIconOnClick() {

    }

    fun novelOnClick(index: Int) {

    }

    fun essayOnClick(index: Int) {

    }

}