package com.chobo.presentation.viewModel.my

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.model.my.MyBookListModel
import com.chobo.domain.usecase.auth.DeleteTokenUseCase
import com.chobo.domain.usecase.auth.LogoutUseCase
import com.chobo.domain.usecase.my.GetMyBookListUseCase
import com.chobo.domain.usecase.my.GetMyInformationUseCase
import com.chobo.domain.usecase.order.OrderDeleteByIdUseCase
import com.chobo.domain.usecase.order.OrderModifyByIdUseCase
import com.chobo.presentation.viewModel.my.uiState.GetMyBookListUiState
import com.chobo.presentation.viewModel.my.uiState.GetMyInformationUiState
import com.chobo.presentation.viewModel.util.Result
import com.chobo.presentation.viewModel.util.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
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
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    companion object {
        const val TITLE = "title"
        const val WRITE = "write"
        const val LINK = "link"
    }

    internal var titleTextState = savedStateHandle.getStateFlow(key = TITLE, initialValue = "")

    internal var writeTextState = savedStateHandle.getStateFlow(key = WRITE, initialValue = "")

    internal var linkTextState = savedStateHandle.getStateFlow(key = LINK, initialValue = "")

    private val _titleTextStateIsEmpty = MutableStateFlow(false)
    val titleTextStateIsEmpty: StateFlow<Boolean> = _titleTextStateIsEmpty.asStateFlow()

    private val _writeTextStateIsEmpty = MutableStateFlow(false)
    val writeTextStateIsEmpty: StateFlow<Boolean> = _writeTextStateIsEmpty.asStateFlow()

    private val _linkTextStateIsEmpty = MutableStateFlow(false)
    val linkTextStateIsEmpty: StateFlow<Boolean> = _linkTextStateIsEmpty.asStateFlow()

    private val _getMyBookListUiState = MutableStateFlow<GetMyBookListUiState>(GetMyBookListUiState.Loading)
    val getMyBookListUiState: StateFlow<GetMyBookListUiState> = _getMyBookListUiState.asStateFlow()

    private val _getMyInformationUiState = MutableStateFlow<GetMyInformationUiState>(GetMyInformationUiState.Loading)
    val getMyInformationUiState: StateFlow<GetMyInformationUiState> = _getMyInformationUiState.asStateFlow()

    private val _isToastVisible = MutableStateFlow(false)
    val isToastVisible: StateFlow<Boolean> = _isToastVisible.asStateFlow()

    private val _isCommunicationSuccess = MutableStateFlow(false)
    val isCommunicationSuccess: StateFlow<Boolean> = _isCommunicationSuccess.asStateFlow()

    var myBookItem: MyBookListModel = MyBookListModel(id = 0, title = "", author = "", bookUrl = "")
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

    fun getMyInformation() = viewModelScope.launch {
        getMyInformationUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _getMyInformationUiState.value = GetMyInformationUiState.Loading
                    is Result.Success -> _getMyInformationUiState.value = GetMyInformationUiState.Success(result.data)
                    is Result.Fail -> _getMyInformationUiState.value = GetMyInformationUiState.Fail
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
                        _getMyBookListUiState.value = GetMyBookListUiState.Success(result.data.toImmutableList())
                    }
                    is Result.Fail -> _getMyBookListUiState.value = GetMyBookListUiState.Fail
                }
            }
    }

    fun orderDeleteById(id: Long) = viewModelScope.launch {
        orderDeleteByIdUseCase(orderId = id)
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> {
                        _isCommunicationSuccess.value = false
                        showToast()
                        getMyBookList()
                    }

                    is Result.Success -> {
                        _isCommunicationSuccess.value = true
                        showToast()
                        getMyBookList()
                    }

                    is Result.Fail -> {
                        _isCommunicationSuccess.value = false
                        showToast()
                        getMyBookList()
                    }
                }
            }
    }

    fun orderModifyById(body: MyBookListModel) = viewModelScope.launch {
        orderModifyByIdUseCase(orderId = body.id, body = body)
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> {
                        _isCommunicationSuccess.value = false
                        showToast()
                        getMyBookList()
                    }

                    is Result.Success -> {
                        savedStateHandle[TITLE] = ""
                        savedStateHandle[WRITE] = ""
                        savedStateHandle[LINK] = ""

                        _isCommunicationSuccess.value = true

                        showToast()
                        getMyBookList()
                    }

                    is Result.Fail -> {
                        _isCommunicationSuccess.value = false
                        showToast()
                        getMyBookList()
                    }
                }
            }
    }

    fun logout() = viewModelScope.launch {
        logoutUseCase()
        deleteTokenUseCase()
    }

    internal fun onTitleChange(title: String) {
        savedStateHandle[TITLE] = title
        _titleTextStateIsEmpty.value = title.isEmpty()
    }

    internal fun onWriteChange(write: String) {
        savedStateHandle[WRITE] = write
        _writeTextStateIsEmpty.value = write.isEmpty()
    }

    internal fun onLinkChange(link: String) {
        savedStateHandle[LINK] = link
        _linkTextStateIsEmpty.value = link.isEmpty()
    }

    internal fun validateAndSetErrorStates(): Boolean {
        val isTitleEmpty = titleTextState.value.isEmpty()
        val isWriteEmpty = writeTextState.value.isEmpty()
        val isLinkEmpty = linkTextState.value.isEmpty()

        _titleTextStateIsEmpty.value = isTitleEmpty
        _writeTextStateIsEmpty.value = isWriteEmpty
        _linkTextStateIsEmpty.value = isLinkEmpty

        return !isTitleEmpty && !isWriteEmpty && !isLinkEmpty
    }
}