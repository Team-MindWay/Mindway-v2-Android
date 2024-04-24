package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.chobo.presentation.view.main.component.GoalReadingListOfBooksReadItemData
import com.chobo.presentation.view.main.component.GoalReadingGraphData
import com.chobo.presentation.view.my.component.MyBookListItemData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class GoalReadingViewModel @Inject constructor() : ViewModel() {
    private val _goalBookRead = MutableStateFlow(0)
    val goalBookRead: StateFlow<Int> = _goalBookRead.asStateFlow()

    private val _goalBookReadSetting = MutableStateFlow("")
    val goalBookReadSetting: StateFlow<String> = _goalBookReadSetting.asStateFlow()

    private val _goalBookReadSettingIsEmpty = MutableStateFlow(false)
    val goalBookReadSettingIsEmpty: StateFlow<Boolean> = _goalBookReadSettingIsEmpty.asStateFlow()

    private val _goalReadingGraphDataList = MutableStateFlow<List<GoalReadingGraphData>>(listOf())
    val goalReadingGraphDataList: StateFlow<List<GoalReadingGraphData>> =
        _goalReadingGraphDataList.asStateFlow()

    private val _goalReadingListOfBooksReadItemDataList =
        MutableStateFlow<List<GoalReadingListOfBooksReadItemData>>(listOf())
    val goalReadingListOfBooksReadItemDataList: StateFlow<List<GoalReadingListOfBooksReadItemData>> =
        _goalReadingListOfBooksReadItemDataList.asStateFlow()

    private val _isToastVisible = MutableStateFlow(false)
    val isToastVisible: StateFlow<Boolean> = _isToastVisible.asStateFlow()

    fun updateGoalBookReadSetting(input:String){
        _goalBookReadSettingIsEmpty.value = false
        _goalBookReadSetting.value = input
    }

    fun goalBookReadSettingOnClick(){
        _goalBookReadSettingIsEmpty.value = _goalBookReadSetting.value.isEmpty()
    }

    fun toggleIsToastVisible(){
        _isToastVisible != _isToastVisible
    }
    init {
        _goalReadingListOfBooksReadItemDataList.value =
            MutableList(30) {
                GoalReadingListOfBooksReadItemData(
                    12,
                    12,
                    "제목",
                    "내용입니다 그렇ewjiofhowehfluieifnhcielhuferhwiegir습니다"
                )
            }
    }
}