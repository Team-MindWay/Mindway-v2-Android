package com.chobo.presentation.viewModel.goal

import androidx.lifecycle.*
import com.chobo.presentation.view.main.component.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoalReadingViewModel @Inject constructor() : ViewModel() {
    private val _goalBookRead = MutableStateFlow(0)
    val goalBookRead: StateFlow<Int> = _goalBookRead.asStateFlow()

    private val _goalBookReadIsEmpty = MutableStateFlow(_goalBookRead.value == 0)
    val goalBookReadIsEmpty: StateFlow<Boolean> = _goalBookReadIsEmpty.asStateFlow()

    private val _goalBookReadSetting = MutableStateFlow("")
    val goalBookReadSetting: StateFlow<String> = _goalBookReadSetting.asStateFlow()

    private val _goalBookReadSettingIsEmpty = MutableStateFlow(false)
    val goalBookReadSettingIsEmpty: StateFlow<Boolean> = _goalBookReadSettingIsEmpty.asStateFlow()

    private val _goalReadingGraphDataList = MutableStateFlow<List<GoalReadingGraphData>>(listOf())
    val goalReadingGraphDataList: StateFlow<List<GoalReadingGraphData>> = _goalReadingGraphDataList.asStateFlow()

    private val _goalReadingListOfBooksReadItemDataList = MutableStateFlow<List<GoalReadingListOfBooksReadItemData>>(listOf())
    val goalReadingListOfBooksReadItemDataList: StateFlow<List<GoalReadingListOfBooksReadItemData>> = _goalReadingListOfBooksReadItemDataList.asStateFlow()

    private val _isToastVisible = MutableStateFlow(false)
    val isToastVisible: StateFlow<Boolean> = _isToastVisible.asStateFlow()

    private val _isSuccess = MutableStateFlow(false)
    val isSuccess: StateFlow<Boolean> = _isSuccess.asStateFlow()

    fun updateGoalBookReadSetting(input: String) {
        _goalBookReadSettingIsEmpty.value = false
        _goalBookReadSetting.value = input
    }

    fun goalBookReadSettingOnClick() {
        _goalBookReadSettingIsEmpty.value = _goalBookReadSetting.value.isEmpty()
    }

    fun showToast() {
        _isToastVisible.value = true
        viewModelScope.launch {
            delay(2000)
            _isToastVisible.value = false
        }
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