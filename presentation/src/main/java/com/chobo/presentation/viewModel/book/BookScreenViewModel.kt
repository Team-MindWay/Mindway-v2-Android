package com.chobo.presentation.viewModel.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.emumtype.OrderRequestBookType
import com.chobo.domain.emumtype.OrderRequestBookType.ESSAY
import com.chobo.domain.emumtype.OrderRequestBookType.NOVEL
import com.chobo.domain.usecase.recommend.GetRecommendBookUseCase
import com.chobo.presentation.viewModel.book.uistate.GetRecommendBookUiState
import com.chobo.presentation.viewModel.util.Result
import com.chobo.presentation.viewModel.util.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookScreenViewModel @Inject constructor(
    private val getRecommendBookUseCase: GetRecommendBookUseCase
) : ViewModel() {
    private val _swipeRefreshLoading = MutableStateFlow(false)
    val swipeRefreshLoading = _swipeRefreshLoading.asStateFlow()

    private val _novelDataList = MutableStateFlow<GetRecommendBookUiState>(GetRecommendBookUiState.Loading)
    val novelDataList: StateFlow<GetRecommendBookUiState> = _novelDataList.asStateFlow()

    private val _essayDataList = MutableStateFlow<GetRecommendBookUiState>(GetRecommendBookUiState.Loading)
    val essayDataList: StateFlow<GetRecommendBookUiState> = _essayDataList.asStateFlow()

    fun getRecommendBook(type: OrderRequestBookType) = viewModelScope.launch {
        _swipeRefreshLoading.value = true
        val targetStateFlow = when (type) {
            NOVEL -> _novelDataList
            ESSAY -> _essayDataList
        }
        getRecommendBookUseCase(type = type.name)
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> {
                        targetStateFlow.value = GetRecommendBookUiState.Loading
                    }
                    is Result.Success -> if (result.data.isEmpty()) {
                        targetStateFlow.value = GetRecommendBookUiState.Empty
                        _swipeRefreshLoading.value = false
                    } else {
                        targetStateFlow.value = GetRecommendBookUiState.Success(result.data)
                        _swipeRefreshLoading.value = false
                    }
                    is Result.Fail -> {
                        targetStateFlow.value = GetRecommendBookUiState.Fail(result.exception)
                        _swipeRefreshLoading.value = false
                    }
                }
            }
    }
}