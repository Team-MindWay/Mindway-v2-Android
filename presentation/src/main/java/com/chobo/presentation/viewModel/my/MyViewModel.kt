package com.chobo.presentation.viewModel.my

import androidx.lifecycle.*
import com.chobo.presentation.view.my.component.MyBookListItemData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor() : ViewModel() {
    private val _myBookListItemDataList = MutableStateFlow<List<MyBookListItemData>>(listOf())
    val myBookListItemDataList: StateFlow<List<MyBookListItemData>> =
        _myBookListItemDataList.asStateFlow()

    private val _myName = MutableStateFlow("")
    val myName: StateFlow<String> = _myName.asStateFlow()

    private val _selectedBookTitle = MutableStateFlow("")
    val selectedBookTitle: StateFlow<String> = _selectedBookTitle.asStateFlow()

    private val _isToastVisible = MutableStateFlow(false)
    val isToastVisible: StateFlow<Boolean> = _isToastVisible.asStateFlow()

    private val _bookDeleteDialogIsVisible = MutableStateFlow(false)
    val bookDeleteDialogIsVisible: StateFlow<Boolean> = _bookDeleteDialogIsVisible.asStateFlow()

    private val _selectedIndex = MutableStateFlow(-1)
    val selectedIndex: StateFlow<Int> = _selectedIndex.asStateFlow()

    fun showToast() {
        _isToastVisible.value = true
        viewModelScope.launch {
            delay(2000)
            _isToastVisible.value = false
        }
    }

    fun toggleBookDeleteDialogIsVisible() {
        _bookDeleteDialogIsVisible.value = !_bookDeleteDialogIsVisible.value
    }

    fun setSelectedIndex(index: Int) {
        _selectedIndex.value = index
    }

    fun editBookOnClick(index: Int) {

    }

    init {
        _myName.value = "내이름"
        _myBookListItemDataList.value =
            MutableList(10) {
                MyBookListItemData(
                    title = "제목입니다",
                    writer = "작가입니다",
                    trashCanOnclick = { },
                )
            }
    }
}