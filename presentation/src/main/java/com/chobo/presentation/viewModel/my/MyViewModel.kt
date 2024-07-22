package com.chobo.presentation.viewModel.my

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.model.my.MyBookListModel
import com.chobo.domain.usecase.auth.DeleteTokenUseCase
import com.chobo.domain.usecase.auth.LogoutUseCase
import com.chobo.domain.usecase.my.GetMyBookListUseCase
import com.chobo.domain.usecase.my.GetMyInformationUseCase
import com.chobo.domain.usecase.order.OrderDeleteByIdUseCase
import com.chobo.domain.usecase.order.OrderModifyByIdUseCase
import com.chobo.presentation.viewModel.my.UiState.GetMyBookListUiState
import com.chobo.presentation.viewModel.my.UiState.GetMyInformationUiState
import com.chobo.presentation.viewModel.util.Result
import com.chobo.presentation.viewModel.util.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase,
    private val deleteTokenUseCase: DeleteTokenUseCase,
    private val getMyInformationUseCase: GetMyInformationUseCase,
    private val getMyBookListUseCase: GetMyBookListUseCase,
    private val orderDeleteByIdUseCase: OrderDeleteByIdUseCase,
    private val orderModifyByIdUseCase: OrderModifyByIdUseCase,
) : ViewModel() {
    private val _getMyBookListUiState = MutableStateFlow<GetMyBookListUiState>(GetMyBookListUiState.Loading)
    val getMyBookListUiState: StateFlow<GetMyBookListUiState> = _getMyBookListUiState.asStateFlow()

    private val _getMyInformationUiState = MutableStateFlow<GetMyInformationUiState>(GetMyInformationUiState.Loading)
    val getMyInformationUiState: StateFlow<GetMyInformationUiState> = _getMyInformationUiState.asStateFlow()

    private val _isToastVisible = MutableStateFlow(false)
    val isToastVisible: StateFlow<Boolean> = _isToastVisible.asStateFlow()

    private val _isCommunicationSuccess = MutableStateFlow(false)
    val isCommunicationSuccess: StateFlow<Boolean> = _isCommunicationSuccess.asStateFlow()

    lateinit var myBookItem: MyBookListModel
        private set

    fun setBook(book: MyBookListModel) {
        myBookItem = book
    }

    private fun showToast() {
        _isToastVisible.value = true
        viewModelScope.launch {
            delay(2000)
            _isToastVisible.value = false
        }
    }

    private fun getMyInformation() = viewModelScope.launch {
        getMyInformationUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _getMyInformationUiState.value = GetMyInformationUiState.Loading
                    is Result.Success -> _getMyInformationUiState.value = GetMyInformationUiState.Success(result.data)
                    is Result.Fail -> _getMyInformationUiState.value = GetMyInformationUiState.Fail(result.exception)
                }
            }
    }

    fun getMyBookList() = viewModelScope.launch {
        getMyBookListUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _getMyBookListUiState.value = GetMyBookListUiState.Loading
                    is Result.Success -> if (result.data.isEmpty()) {
                        _getMyBookListUiState.value = GetMyBookListUiState.Empty
                    } else {
                        _getMyBookListUiState.value = GetMyBookListUiState.Success(result.data)
                    }
                    is Result.Fail -> _getMyBookListUiState.value = GetMyBookListUiState.Fail(result.exception)
                }
            }
    }

    fun orderDeleteById(id: Long) = viewModelScope.launch {
        orderDeleteByIdUseCase(orderId = id)
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _isCommunicationSuccess.value = false
                    is Result.Success -> {
                        _isCommunicationSuccess.value = true
                    }
                    is Result.Fail -> _isCommunicationSuccess.value = false
                }
            }
        showToast()
        getMyBookList()
    }

    fun orderModifyById(id: Long, body: MyBookListModel) = viewModelScope.launch {
        orderModifyByIdUseCase(orderId = id, body = body)
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _isCommunicationSuccess.value = false
                    is Result.Success -> {
                        _isCommunicationSuccess.value = true
                    }
                    is Result.Fail -> _isCommunicationSuccess.value = false
                }
            }
        showToast()
        getMyBookList()
    }

    fun logout() = viewModelScope.launch {
        logoutUseCase()
        deleteTokenUseCase()
    }

    init {
        getMyInformation()
        getMyBookList()
    }
}