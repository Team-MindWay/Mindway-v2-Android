package com.chobo.mindway_v2_android

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.data.local.datasource.LocalAuthDataSource
import com.chobo.domain.exception.NeedLoginException
import com.chobo.domain.usecase.auth.SaveLoginDataUseCase
import com.chobo.domain.usecase.auth.TokenRefreshUseCase
import com.chobo.presentation.viewModel.util.Result
import com.chobo.presentation.viewModel.util.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val saveTokenUseCase: SaveLoginDataUseCase,
    private val tokenRefreshUseCase: TokenRefreshUseCase,
    private val localAuthDataSource: LocalAuthDataSource
) : ViewModel() {

    private val _uiState = mutableStateOf<MainActivityUiState>(MainActivityUiState.Loading)
    val uiState: State<MainActivityUiState> = _uiState

    init {
        tokenRefresh()
    }

    private fun tokenRefresh() = viewModelScope.launch {
        val refreshToken = localAuthDataSource.getRefreshToken().firstOrNull()

        if (refreshToken.isNullOrEmpty()) {
            _uiState.value = MainActivityUiState.Fail
        } else {
            tokenRefreshUseCase(refreshToken)
                .asResult()
                .collectLatest { result ->
                    when (result) {
                        is Result.Fail -> _uiState.value = MainActivityUiState.Fail

                        is Result.Loading -> _uiState.value = MainActivityUiState.Loading
                        is Result.Success -> {
                            saveTokenUseCase(result.data).onSuccess {
                                _uiState.value = MainActivityUiState.Success
                            }
                        }
                    }
                }
        }
    }

}

sealed interface MainActivityUiState {
    object Loading : MainActivityUiState
    object Success : MainActivityUiState
    object Fail : MainActivityUiState
}