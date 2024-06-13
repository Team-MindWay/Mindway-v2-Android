package com.chobo.data.remote.datasource.auth

import com.chobo.data.remote.dto.auth.request.GAuthLoginRequestBody
import com.chobo.data.remote.dto.auth.response.GAuthLoginResponse
import kotlinx.coroutines.flow.Flow

interface RemoteAuthDataSource {
    suspend fun GuauthLogin(body: GAuthLoginRequestBody) : Flow<GAuthLoginResponse>

    suspend fun GuathLogout() : Flow<Unit>

    suspend fun GuathAccess(): Flow<GAuthLoginResponse>
}