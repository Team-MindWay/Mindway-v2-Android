package com.chobo.domain.usecase.auth

import com.chobo.domain.model.auth.request.GAuthLoginRequestModel
import com.chobo.domain.repository.AuthRepository
import javax.inject.Inject

class GAuthLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(body: GAuthLoginRequestModel) = runCatching {
        authRepository.gAuthLogin(body = body)
    }
}