package com.chobo.data.repository

import com.chobo.data.local.datasource.LocalAuthDataSource
import com.chobo.data.remote.datasource.auth.RemoteAuthDataSource
import com.chobo.data.remote.dto.auth.request.GAuthLoginRequestBody
import com.chobo.data.remote.dto.auth.response.toLoginModel
import com.chobo.domain.model.auth.request.GAuthLoginRequestModel
import com.chobo.domain.model.auth.response.GAuthLoginResponseModel
import com.chobo.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val localAuthDataSource: LocalAuthDataSource,
    private val remoteAuthDataSource: RemoteAuthDataSource
): AuthRepository {
    override suspend fun gAuthLogin(body: GAuthLoginRequestModel): Flow<GAuthLoginResponseModel> {
        return remoteAuthDataSource.GuauthLogin(body = GAuthLoginRequestBody(code = body.code)).map { it.toLoginModel() }
    }

    override suspend fun saveLoginData(data: GAuthLoginResponseModel) {
        data.let {
            localAuthDataSource.setAccessToken(it.accessToken)
            localAuthDataSource.setAccessTime(it.accessTokenExpiresIn)
            localAuthDataSource.setRefreshToken(it.refreshToken)
            localAuthDataSource.setRefreshTime(it.refreshTokenExpiresIn)
        }
    }

    override suspend fun logout(): Flow<Unit> {
        return remoteAuthDataSource.GuathLogout()
    }

    override suspend fun deleteLoginData() {
        localAuthDataSource.deleteAccessToken()
        localAuthDataSource.deleteAccessTime()
        localAuthDataSource.deleteRefreshToken()
        localAuthDataSource.deleteRefreshTime()
    }
}