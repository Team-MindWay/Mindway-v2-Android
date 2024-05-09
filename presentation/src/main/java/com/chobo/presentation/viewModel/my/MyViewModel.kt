package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.presentation.view.my.component.MyBookListItemData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor() : ViewModel() {
    private val _myBookListItemDataList = MutableStateFlow<List<MyBookListItemData>>(listOf())
    val myBookListItemDataList: StateFlow<List<MyBookListItemData>> = _myBookListItemDataList.asStateFlow()

    private val _myName = MutableStateFlow("")
    val myName: StateFlow<String> = _myName.asStateFlow()

    private val _isToastVisible = MutableStateFlow(false)
    val isToastVisible: StateFlow<Boolean> = _isToastVisible.asStateFlow()

    fun showToast() {
        _isToastVisible.value = true
        viewModelScope.launch {
            delay(2000)
            _isToastVisible.value = false
        }
    }

    fun removeBookItem(position: Int) {
        val currentList = _myBookListItemDataList.value.toMutableList()
        if (position in currentList.indices) {
            currentList.removeAt(position)
            _myBookListItemDataList.value = currentList
        }
    }

    init {
        _myName.value = "내이름"
        _myBookListItemDataList.value =
            MutableList(10) { index ->
                MyBookListItemData(
                    title = "제목입니다",
                    writer = "작가입니다",
                    trashCanOnclick = { removeBookItem(index) },
                )
            }
    }
}