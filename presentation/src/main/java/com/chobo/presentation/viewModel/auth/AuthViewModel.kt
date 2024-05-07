package com.chobo.presentation.viewModel.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.model.auth.request.GAuthLoginRequestModel
import com.chobo.domain.model.auth.response.GAuthLoginResponseModel
import com.chobo.domain.usecase.auth.DeleteTokenUseCase
import com.chobo.domain.usecase.auth.GAuthLoginUseCase
import com.chobo.domain.usecase.auth.LogoutUseCase
import com.chobo.domain.usecase.auth.SaveLoginDataUseCase
import com.chobo.presentation.viewModel.util.Event
import com.chobo.presentation.viewModel.util.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val gAuthLoginUseCase: GAuthLoginUseCase,
    private val saveTokenUseCase: SaveLoginDataUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val deleteTokenUseCase: DeleteTokenUseCase
) : ViewModel() {
    private val _gAuthLoginRequest = MutableLiveData<Event<GAuthLoginResponseModel>>()
    val gAuthLoginRequest: LiveData<Event<GAuthLoginResponseModel>> get() = _gAuthLoginRequest

    private val _saveTokenRequest = MutableLiveData<Event<Nothing>>()
    val saveTokenRequest: LiveData<Event<Nothing>> get() = _saveTokenRequest

    fun gAuthLogin(code: String) = viewModelScope.launch {
        gAuthLoginUseCase(GAuthLoginRequestModel(code = code))
            .onSuccess {
                it.catch { remoteError ->
                    _gAuthLoginRequest.value = remoteError.errorHandling()
                }.collect { response ->
                    _gAuthLoginRequest.value = Event.Success(data = response)
                }
            }
            .onFailure {
                _gAuthLoginRequest.value = it.errorHandling()
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

    fun logout() = viewModelScope.launch {
        logoutUseCase()
    }

    fun deleteToken() = viewModelScope.launch {
        deleteTokenUseCase()
    }
}