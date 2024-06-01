package com.chobo.presentation.viewModel.goal

import androidx.lifecycle.*
import com.chobo.domain.usecase.goal.GetWeekendGoalUseCase
import com.chobo.presentation.view.main.component.*
import com.chobo.presentation.viewModel.main.uistate.GetWeekendGoalUiState
import com.chobo.presentation.viewModel.util.result.Result
import com.chobo.presentation.viewModel.util.result.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoalReadingViewModel @Inject constructor(
    private val getWeekendGoalUseCase: GetWeekendGoalUseCase
) : ViewModel() {
    private val _getWeekendGoalUiState = MutableStateFlow<GetWeekendGoalUiState>(GetWeekendGoalUiState.Loading)
    val getWeekendGoalUiState: StateFlow<GetWeekendGoalUiState> = _getWeekendGoalUiState.asStateFlow()

    private val _goalBookReadSetting = MutableStateFlow("")
    val goalBookReadSetting: StateFlow<String> = _goalBookReadSetting.asStateFlow()

    private val _goalBookReadSettingIsEmpty = MutableStateFlow(false)
    val goalBookReadSettingIsEmpty: StateFlow<Boolean> = _goalBookReadSettingIsEmpty.asStateFlow()

    private val _goalReadingListOfBooksReadItemDataList = MutableStateFlow<List<GoalReadingListOfBooksReadItemData>>(listOf())
    val goalReadingListOfBooksReadItemDataList: StateFlow<List<GoalReadingListOfBooksReadItemData>> = _goalReadingListOfBooksReadItemDataList.asStateFlow()

    private val _isToastVisible = MutableStateFlow(false)
    val isToastVisible: StateFlow<Boolean> = _isToastVisible.asStateFlow()

    private val _isSuccess = MutableStateFlow(false)
    val isSuccess: StateFlow<Boolean> = _isSuccess.asStateFlow()

    fun getWeekendGoal() = viewModelScope.launch {
        getWeekendGoalUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _getWeekendGoalUiState.value = GetWeekendGoalUiState.Loading
                    is Result.Success -> if (result.data.now_count + result.data.goal_value == 0) {
                        _getWeekendGoalUiState.value = GetWeekendGoalUiState.Empty
                    } else {
                        _getWeekendGoalUiState.value = GetWeekendGoalUiState.Success(result.data)
                    }

                    is Result.Fail -> _getWeekendGoalUiState.value = GetWeekendGoalUiState.Fail(result.exception)
                }
            }
    }
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