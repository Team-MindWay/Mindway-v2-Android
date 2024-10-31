package com.chobo.domain.usecase.auth

import com.chobo.domain.model.auth.response.GAuthLoginResponseModel
import com.chobo.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TokenRefreshUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator suspend fun invoke(refreshToken: String): Flow<GAuthLoginResponseModel> =
        authRepository.gAuthAccess(refreshToken = "Bearer $refreshToken")
}