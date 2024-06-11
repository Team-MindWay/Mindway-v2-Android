package com.chobo.presentation.viewModel.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.model.auth.request.GAuthLoginRequestModel
import com.chobo.domain.model.auth.response.GAuthLoginResponseModel
import com.chobo.domain.usecase.auth.GAuthLoginUseCase
import com.chobo.domain.usecase.auth.SaveLoginDataUseCase
import com.chobo.presentation.viewModel.auth.uistate.AuthUiState
import com.chobo.presentation.viewModel.util.Event
import com.chobo.presentation.viewModel.util.errorHandling
import com.chobo.presentation.viewModel.util.result.Result
import com.chobo.presentation.viewModel.util.result.asResult
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
    private val _authUiState = MutableStateFlow<AuthUiState>(AuthUiState.Loading)
    val authUiState: StateFlow<AuthUiState> = _authUiState.asStateFlow()

    private val _gAuthLoginRequest = MutableLiveData<Event<GAuthLoginResponseModel>>()
    val gAuthLoginRequest: LiveData<Event<GAuthLoginResponseModel>> get() = _gAuthLoginRequest

    private val _saveTokenRequest = MutableLiveData<Event<Nothing>>()
    val saveTokenRequest: LiveData<Event<Nothing>> get() = _saveTokenRequest

    fun gAuthLogin(code: String) = viewModelScope.launch {
        gAuthLoginUseCase(GAuthLoginRequestModel(code = code))
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Fail -> _authUiState.value = AuthUiState.Fail(result.exception)
                    is Result.Loading -> _authUiState.value = AuthUiState.Loading
                    is Result.Success -> {
                        saveLoginData(result.data)
                        _authUiState.value = AuthUiState.Success
                    }
                }
            }
    }

    fun saveLoginData(data: GAuthLoginResponseModel) = viewModelScope.launch {
        saveTokenUseCase(data = data)
            .onSuccess {
                _saveTokenRequest.value = Event.Success()
            }
            .onFailure {
                _saveTokenRequest.value = it.errorHandling()
            }
    }
}