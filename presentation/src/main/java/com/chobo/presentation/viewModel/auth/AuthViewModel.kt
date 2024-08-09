package com.chobo.presentation.viewModel.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.model.auth.request.GAuthLoginRequestModel
import com.chobo.domain.model.auth.response.GAuthLoginResponseModel
import com.chobo.domain.usecase.auth.GAuthLoginUseCase
import com.chobo.domain.usecase.auth.SaveLoginDataUseCase
import com.chobo.presentation.viewModel.auth.uistate.AuthUiState
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
class AuthViewModel @Inject constructor(
    private val gAuthLoginUseCase: GAuthLoginUseCase,
    private val saveTokenUseCase: SaveLoginDataUseCase,
) : ViewModel() {
    private val _isSuccessSaveLoginData = MutableStateFlow(false)
    val isSuccessSaveLoginData: StateFlow<Boolean> = _isSuccessSaveLoginData.asStateFlow()

    fun gAuthLogin(code: String) = viewModelScope.launch {
        gAuthLoginUseCase(GAuthLoginRequestModel(code = code))
            .onSuccess {
                it.collect { result ->
                    saveLoginData(result)
                }
            }
    }

    private fun saveLoginData(data: GAuthLoginResponseModel) = viewModelScope.launch {
        saveTokenUseCase(data = data)
            .onSuccess {
                _isSuccessSaveLoginData.value = true
            }
            .onFailure {
                _isSuccessSaveLoginData.value = false
            }
    }
}