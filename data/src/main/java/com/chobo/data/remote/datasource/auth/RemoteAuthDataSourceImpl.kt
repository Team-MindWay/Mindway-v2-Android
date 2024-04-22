package com.chobo.data.remote.datasource.auth

import com.chobo.data.remote.api.AuthAPI
import com.chobo.data.remote.dto.auth.request.GAuthPostRequestBody
import com.chobo.data.remote.dto.auth.response.GAuthLoginResponse
import com.chobo.data.util.MindWayAPIHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteAuthDataSourceImpl @Inject constructor(
    private val authService: AuthAPI
) : RemoteAuthDataSource {
    override suspend fun GuauthLogin(body: GAuthPostRequestBody): Flow<GAuthLoginResponse> = flow {
        emit(
            MindWayAPIHandler<GAuthLoginResponse>()
                .httpRequest { authService.gAuthLogin(body = body) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun GuathLogout(): Flow<Unit> = flow {
        emit(
            MindWayAPIHandler<Unit>()
                .httpRequest { authService.gAuthLogout() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}