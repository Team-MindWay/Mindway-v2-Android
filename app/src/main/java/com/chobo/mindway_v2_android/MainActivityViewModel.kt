package com.chobo.mindway_v2_android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.model.auth.response.GAuthLoginResponseModel
import com.chobo.domain.usecase.auth.SaveLoginDataUseCase
import com.chobo.domain.usecase.auth.TokenRefreshUseCase
import com.chobo.presentation.viewModel.util.Result
import com.chobo.presentation.viewModel.util.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val saveTokenUseCase: SaveLoginDataUseCase,
    private val tokenRefreshUseCase: TokenRefreshUseCase,
): ViewModel() {

    val uiState: StateFlow<MainActivityUiState> = flow {
        tokenRefreshUseCase().collect {
            emit(it)
        }
    }
        .asResult()
        .map { result ->
            when (result) {
                is Result.Fail -> MainActivityUiState.Fail(result.exception)
                is Result.Loading -> MainActivityUiState.Loading
                is Result.Success -> MainActivityUiState.Success(result.data)
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MainActivityUiState.Loading
        )

    fun saveLoginToken(data: GAuthLoginResponseModel) = viewModelScope.launch {
        saveTokenUseCase(data = data)
    }
}


sealed interface MainActivityUiState {
    object Loading : MainActivityUiState
    data class Success(val gAuthLoginResponseModel: GAuthLoginResponseModel) : MainActivityUiState
    data class Fail(val exception: Throwable) : MainActivityUiState
}