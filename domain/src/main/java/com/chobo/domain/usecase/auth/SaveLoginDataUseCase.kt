package com.chobo.domain.usecase.auth

import com.chobo.domain.model.auth.response.GAuthLoginResponseModel
import com.chobo.domain.repository.AuthRepository
import javax.inject.Inject

class SaveLoginDataUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(data: GAuthLoginResponseModel) = runCatching {
        authRepository.saveLoginData(data)
    }
}