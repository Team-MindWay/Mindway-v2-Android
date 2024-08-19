package com.chobo.presentation.viewModel.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.model.order.OrderRequestBodyModel
import com.chobo.domain.usecase.order.OrderUploadUseCase
import com.chobo.presentation.viewModel.book.uistate.OrderUploadUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookAddBookViewModel @Inject constructor(
    private val orderUploadUseCase: OrderUploadUseCase
) : ViewModel() {
    private val _orderUploadUiState = MutableStateFlow<OrderUploadUiState>(OrderUploadUiState.Loading)
    val orderUploadUiState: StateFlow<OrderUploadUiState> = _orderUploadUiState.asStateFlow()

    fun checkButtonOnClick(
        titleTextState: String,
        writeTextState: String,
        linkTextState: String,
    ) =
        viewModelScope.launch {
            orderUploadUseCase(
                body = OrderRequestBodyModel(
                    title = titleTextState,
                    author = writeTextState,
                    book_url = linkTextState
                )
            )
                .onSuccess {
                    it.catch {
                        _orderUploadUiState.value = OrderUploadUiState.Fail
                    }.collect {
                        _orderUploadUiState.value = OrderUploadUiState.Success
                    }
                }
                .onFailure {
                    _orderUploadUiState.value = OrderUploadUiState.Fail
                }
        }
}