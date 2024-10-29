package com.chobo.data.repository

import android.util.Log
import com.chobo.data.local.datasource.LocalAuthDataSource
import com.chobo.data.remote.datasource.auth.RemoteAuthDataSource
import com.chobo.data.remote.dto.auth.request.toDto
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
) : AuthRepository {
    override fun gAuthLogin(body: GAuthLoginRequestModel): Flow<GAuthLoginResponseModel> =
        remoteAuthDataSource.GuauthLogin(body = body.toDto()).map { it.toLoginModel() }

    override suspend fun gAuthAccess(refreshToken: String): Flow<GAuthLoginResponseModel> =
        remoteAuthDataSource.GuathAccess(refreshToken = refreshToken).map { it.toLoginModel() }

    override fun getGAuthAccess(): Flow<String> =
        localAuthDataSource.getRefreshToken()

    override suspend fun saveLoginData(data: GAuthLoginResponseModel) {
        with(data) {
            with(localAuthDataSource) {
                setAccessToken(accessToken)
                setAccessTime(accessTokenExpiresIn)
                setRefreshToken(refreshToken)
                setRefreshTime(refreshTokenExpiresIn)
            }
        }
    }

    override fun logout(): Flow<Unit> =
        remoteAuthDataSource.GuathLogout()

    override suspend fun deleteLoginData() {
        with(localAuthDataSource) {
            deleteAccessTime()
            deleteAccessToken()
            deleteRefreshTime()
            deleteRefreshToken()
        }
    }
}