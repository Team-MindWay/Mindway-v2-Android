package com.chobo.presentation.viewModel.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.model.auth.request.GAuthLoginRequestModel
import com.chobo.domain.model.auth.response.GAuthLoginResponseModel
import com.chobo.domain.usecase.auth.GAuthLoginUseCase
import com.chobo.domain.usecase.auth.SaveLoginDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val gAuthLoginUseCase: GAuthLoginUseCase,
    private val saveTokenUseCase: SaveLoginDataUseCase,
) : ViewModel() {
    fun gAuthLogin(
        code: String,
        onSuccess: () -> Unit,
    ) = viewModelScope.launch {
        gAuthLoginUseCase(GAuthLoginRequestModel(code = code))
            .onSuccess {
                it.collect { result ->
                    saveLoginData(
                        data = result,
                        onSuccess = onSuccess,
                    )
                }
            }
    }

    private fun saveLoginData(
        data: GAuthLoginResponseModel,
        onSuccess: () -> Unit,
    ) = viewModelScope.launch {
        saveTokenUseCase(data = data)
            .onSuccess {
                onSuccess()
            }
            .onFailure {

            }
    }
}