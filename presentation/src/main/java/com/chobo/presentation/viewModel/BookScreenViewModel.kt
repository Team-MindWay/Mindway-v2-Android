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
    private val _novelDataList = MutableStateFlow<List<BookListItemData>>(listOf())
    val novelDataList: StateFlow<List<BookListItemData>> = _novelDataList.asStateFlow()

    private val _essayDataList = MutableStateFlow<List<BookListItemData>>(listOf())
    val essayDataList: StateFlow<List<BookListItemData>> = _essayDataList.asStateFlow()

    private val _isToastVisible = MutableStateFlow(false)
    val isToastVisible: StateFlow<Boolean> = _isToastVisible.asStateFlow()
    fun plusIconOnClick() {

    }

    fun novelOnClick(index: Int) {

    }

    fun essayOnClick(index: Int) {

    }

    fun toggleIsToastVisible(){
        _isToastVisible != _isToastVisible
    }

    init {
        _novelDataList.value = MutableList(30) { _ ->
            BookListItemData(
                writer = "작가이름",
                title = "제옴ㄹ",
                content = "내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용"
            )
        }
        _essayDataList.value = MutableList(30) { _ ->
            BookListItemData(
                writer = "gw",
                title = "제옴ㄹ",
                content = "czxczxc"
            )
        }
    }
}