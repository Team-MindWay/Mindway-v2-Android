package com.chobo.data.local.datasource

import kotlinx.coroutines.flow.Flow


interface LocalAuthDataSource {
    suspend fun getAccessToken(): Flow<String>
    suspend fun setAccessToken(accessToken: String)
    suspend fun deleteAccessToken()

    suspend fun getAccessTime(): Flow<String>
    suspend fun setAccessTime(accessToken: String)
    suspend fun deleteAccessTime()

    suspend fun getRefreshToken(): Flow<String>
    suspend fun setRefreshToken(refreshToken: String)
    suspend fun deleteRefreshToken()

    suspend fun getRefreshTime(): Flow<String>
    suspend fun setRefreshTime(refreshToken: String)
    suspend fun deleteRefreshTime()
}