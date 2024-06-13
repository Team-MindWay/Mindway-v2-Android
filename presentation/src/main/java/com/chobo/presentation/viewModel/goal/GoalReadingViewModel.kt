package com.chobo.presentation.viewModel.goal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.model.goal.request.PostGoalRequestModel
import com.chobo.domain.usecase.book.GetBookListUseCase
import com.chobo.domain.usecase.goal.GetWeekendGoalUseCase
import com.chobo.domain.usecase.goal.PostGoalRequestUseCase
import com.chobo.presentation.viewModel.goal.uistate.GetBookListUiState
import com.chobo.presentation.viewModel.main.uistate.GetWeekendGoalUiState
import com.chobo.presentation.viewModel.util.result.Result
import com.chobo.presentation.viewModel.util.result.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoalReadingViewModel @Inject constructor(
    private val getWeekendGoalUseCase: GetWeekendGoalUseCase,
    private val getBookListUseCase: GetBookListUseCase,
    private val postGoalRequestUseCase: PostGoalRequestUseCase,
) : ViewModel() {
    private val _swipeRefreshLoading = MutableStateFlow(false)
    val swipeRefreshLoading = _swipeRefreshLoading.asStateFlow()

    private val _getWeekendGoalUiState = MutableStateFlow<GetWeekendGoalUiState>(GetWeekendGoalUiState.Loading)
    val getWeekendGoalUiState: StateFlow<GetWeekendGoalUiState> = _getWeekendGoalUiState.asStateFlow()

    private val _getBookListUiState = MutableStateFlow<GetBookListUiState>(GetBookListUiState.Loading)
    val getBookListUiState: StateFlow<GetBookListUiState> = _getBookListUiState.asStateFlow()

    private val _goalBookReadSetting = MutableStateFlow("")
    val goalBookReadSetting: StateFlow<String> = _goalBookReadSetting.asStateFlow()

    private val _goalBookReadSettingIsEmpty = MutableStateFlow(false)
    val goalBookReadSettingIsEmpty: StateFlow<Boolean> = _goalBookReadSettingIsEmpty.asStateFlow()

    private val _isToastVisible = MutableStateFlow(false)
    val isToastVisible: StateFlow<Boolean> = _isToastVisible.asStateFlow()

    private val _isSuccess = MutableStateFlow(false)
    val isSuccess: StateFlow<Boolean> = _isSuccess.asStateFlow()

    fun loadStuff() {
        viewModelScope.launch {
            _swipeRefreshLoading.value = true
            delay(1000L)
            _swipeRefreshLoading.value = false
        }
    }

    fun getWeekendGoal() = viewModelScope.launch {
        getWeekendGoalUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _getWeekendGoalUiState.value = GetWeekendGoalUiState.Loading
                    is Result.Success -> if (result.data.goal_value == 0) {
                        _getWeekendGoalUiState.value = GetWeekendGoalUiState.Empty
                    } else {
                        _getWeekendGoalUiState.value = GetWeekendGoalUiState.Success(result.data)
                    }
                    is Result.Fail -> _getWeekendGoalUiState.value = GetWeekendGoalUiState.Fail(result.exception)
                }
            }
    }

    fun getBookList() = viewModelScope.launch {
        getBookListUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _getBookListUiState.value = GetBookListUiState.Loading
                    is Result.Success -> if (result.data.isEmpty()) {
                        _getBookListUiState.value = GetBookListUiState.Empty
                    } else {
                        _getBookListUiState.value = GetBookListUiState.Success(result.data)
                    }
                    is Result.Fail -> _getBookListUiState.value = GetBookListUiState.Fail(result.exception)
                }
            }
    }

    fun updateGoalBookReadSetting(input: String) {
        _goalBookReadSettingIsEmpty.value = false
        _goalBookReadSetting.value = input
    }

    fun goalBookReadSettingOnClick() {
        _goalBookReadSettingIsEmpty.value = _goalBookReadSetting.value.isEmpty()
        if (!_goalBookReadSettingIsEmpty.value && _goalBookReadSetting.value.toIntOrNull() != null) {
            viewModelScope.launch {
                postGoalRequestUseCase(
                    body = PostGoalRequestModel(goal_count = _goalBookReadSetting.value.toInt())
                )
                    .asResult()
                    .collectLatest { }
            }
        }
    }

    fun showToast() {
        _isToastVisible.value = true
        viewModelScope.launch {
            delay(2000)
            _isToastVisible.value = false
        }
    }

    init {
        loadStuff()
        getBookList()
        getWeekendGoal()
    }
}