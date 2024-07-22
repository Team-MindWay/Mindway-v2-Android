package com.chobo.mindway_v2_android

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.model.auth.response.GAuthLoginResponseModel
import com.chobo.domain.usecase.auth.SaveLoginDataUseCase
import com.chobo.domain.usecase.auth.TokenRefreshUseCase
import com.chobo.presentation.viewModel.util.Result
import com.chobo.presentation.viewModel.util.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val saveTokenUseCase: SaveLoginDataUseCase,
    private val tokenRefreshUseCase: TokenRefreshUseCase,
) : ViewModel() {

    var uiState: MutableState<MainActivityUiState> = mutableStateOf(MainActivityUiState.Loading)

    init {
        tokenRefresh()
    }

    private fun saveLoginToken(data: GAuthLoginResponseModel) = viewModelScope.launch {
        saveTokenUseCase(data = data)
        Log.d("saveLoginToken", data.toString())
    }

    private fun tokenRefresh() = viewModelScope.launch {
        tokenRefreshUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Fail -> uiState.value = MainActivityUiState.Fail(result.exception)
                    is Result.Loading -> uiState.value = MainActivityUiState.Loading
                    is Result.Success -> {
                        saveLoginToken(result.data)
                        uiState.value = MainActivityUiState.Success(result.data)
                    }
                }
            }
    }
}

sealed interface MainActivityUiState {
    object Loading : MainActivityUiState
    data class Success(val gAuthLoginResponseModel: GAuthLoginResponseModel) : MainActivityUiState
    data class Fail(val exception: Throwable) : MainActivityUiState
}