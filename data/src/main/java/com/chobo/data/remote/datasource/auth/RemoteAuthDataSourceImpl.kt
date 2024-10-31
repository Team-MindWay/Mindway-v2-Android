package com.chobo.data.remote.datasource.auth

import com.chobo.data.remote.api.AuthAPI
import com.chobo.data.remote.dto.auth.request.GAuthLoginRequestBody
import com.chobo.data.remote.dto.auth.response.GAuthLoginResponse
import com.chobo.data.util.performApiRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteAuthDataSourceImpl @Inject constructor(
    private val authService: AuthAPI
) : RemoteAuthDataSource {
    override fun GuauthLogin(body: GAuthLoginRequestBody): Flow<GAuthLoginResponse> =
        performApiRequest { authService.gAuthLogin(body = body) }

    override fun GuathLogout(): Flow<Unit> =
        performApiRequest { authService.gAuthLogout() }

    override suspend fun GuathAccess(refreshToken: String): Flow<GAuthLoginResponse> =
        performApiRequest { authService.gAuthAccess(refreshToken = refreshToken) }
}