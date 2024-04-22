package com.chobo.data.local.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.chobo.data.local.key.AuthDataStoreKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalAuthDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
): LocalAuthDataSource {
    override suspend fun getAccessToken(): Flow<String> = dataStore.data.map {
        it[AuthDataStoreKey.ACCESS_TOKEN] ?: ""
    }

    override suspend fun setAccessToken(accessToken: String) {
        dataStore.edit {
            it[AuthDataStoreKey.ACCESS_TOKEN] = accessToken
        }
    }

    override suspend fun deleteAccessToken() {
        dataStore.edit {
            it.remove(AuthDataStoreKey.ACCESS_TOKEN)
        }
    }

    override suspend fun getAccessTime(): Flow<String> = dataStore.data.map {
        it[AuthDataStoreKey.ACCESS_TIME] ?: ""
    }

    override suspend fun setAccessTime(accessToken: String) {
        dataStore.edit {
            it[AuthDataStoreKey.ACCESS_TIME] = accessToken
        }
    }

    override suspend fun deleteAccessTime() {
        dataStore.edit {
            it.remove(AuthDataStoreKey.ACCESS_TIME)
        }
    }

    override suspend fun getRefreshToken(): Flow<String> = dataStore.data.map {
        it[AuthDataStoreKey.REFRESH_TOKEN] ?: ""
    }

    override suspend fun setRefreshToken(refreshToken: String) {
        dataStore.edit {
            it[AuthDataStoreKey.REFRESH_TOKEN] = refreshToken
        }
    }

    override suspend fun deleteRefreshToken() {
        dataStore.edit {
            it.remove(AuthDataStoreKey.REFRESH_TOKEN)
        }
    }

    override suspend fun getRefreshTime(): Flow<String> = dataStore.data.map {
        it[AuthDataStoreKey.REFRESH_TIME] ?: ""
    }

    override suspend fun setRefreshTime(refreshToken: String) {
        dataStore.edit {
            it[AuthDataStoreKey.REFRESH_TIME] = refreshToken
        }
    }

    override suspend fun deleteRefreshTime() {
        dataStore.edit {
            it.remove(AuthDataStoreKey.REFRESH_TIME)
        }
    }
}