package com.chobo.data.remote.datasource.auth

import com.chobo.data.remote.dto.auth.request.GAuthPostRequestBody
import com.chobo.data.remote.dto.auth.response.GAuthDeleteResponse
import kotlinx.coroutines.flow.Flow

interface RemoteAuthDataSource {
    suspend fun GuauthLogin(body: GAuthPostRequestBody) : Flow<GAuthDeleteResponse>

    suspend fun GuathLogout() : Flow<Unit>
}