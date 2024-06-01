package com.chobo.presentation.viewModel.my

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.usecase.auth.DeleteTokenUseCase
import com.chobo.domain.usecase.auth.LogoutUseCase
import com.chobo.domain.usecase.auth.SaveLoginDataUseCase
import com.chobo.domain.usecase.my.GetMyInformationUseCase
import com.chobo.presentation.view.my.component.MyBookListItemData
import com.chobo.presentation.viewModel.main.uistate.GetWeekendGoalUiState
import com.chobo.presentation.viewModel.my.UiState.GetMyInformationUiState
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
class MyViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase,
    private val deleteTokenUseCase: DeleteTokenUseCase,
    private val getMyInformationUseCase: GetMyInformationUseCase,
) : ViewModel() {
    private val _myBookListItemDataList = MutableStateFlow<List<MyBookListItemData>>(listOf())
    val myBookListItemDataList: StateFlow<List<MyBookListItemData>> = _myBookListItemDataList.asStateFlow()

    private val _getMyInformationUiState = MutableStateFlow<GetMyInformationUiState>(GetMyInformationUiState.Loading)
    val getMyInformationUiState: StateFlow<GetMyInformationUiState> = _getMyInformationUiState.asStateFlow()

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

    fun getMyInformation() = viewModelScope.launch {
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

    fun toggleBookDeleteDialogIsVisible() {
        _bookDeleteDialogIsVisible.value = !_bookDeleteDialogIsVisible.value
    }

    fun setSelectedIndex(index: Int) {
        _selectedIndex.value = index
    }

    fun editBookOnClick(index: Int) {

    }

    fun logout() = viewModelScope.launch {
        logoutUseCase()
        deleteTokenUseCase()
    }


    init {
        getMyInformation()
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