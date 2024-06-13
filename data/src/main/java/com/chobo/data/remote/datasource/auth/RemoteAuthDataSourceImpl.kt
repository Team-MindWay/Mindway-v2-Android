package com.chobo.data.remote.datasource.auth

import com.chobo.data.remote.api.AuthAPI
import com.chobo.data.remote.dto.auth.request.GAuthLoginRequestBody
import com.chobo.data.remote.dto.auth.response.GAuthLoginResponse
import com.chobo.data.util.performApiRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteAuthDataSourceImpl @Inject constructor(
    private val authService: AuthAPI
) : RemoteAuthDataSource {
    override suspend fun GuauthLogin(body: GAuthLoginRequestBody): Flow<GAuthLoginResponse> = flow {
        performApiRequest { authService.gAuthLogin(body = body) }
    }

    override suspend fun GuathLogout(): Flow<Unit> = flow {
        performApiRequest { authService.gAuthLogout() }
    }
}