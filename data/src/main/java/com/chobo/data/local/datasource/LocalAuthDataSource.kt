package com.chobo.data.local.datasource

import kotlinx.coroutines.flow.Flow


interface LocalAuthDataSource {
    fun getAccessToken(): Flow<String>
    suspend fun setAccessToken(accessToken: String)
    suspend fun deleteAccessToken()

    fun getAccessTime(): Flow<String>
    suspend fun setAccessTime(accessTime: String)
    suspend fun deleteAccessTime()

    fun getRefreshToken(): Flow<String>
    suspend fun setRefreshToken(refreshToken: String)
    suspend fun deleteRefreshToken()

    fun getRefreshTime(): Flow<String>
    suspend fun setRefreshTime(refreshTime: String)
    suspend fun deleteRefreshTime()
}
