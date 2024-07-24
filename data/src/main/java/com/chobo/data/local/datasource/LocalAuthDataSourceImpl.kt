package com.chobo.data.local.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalAuthDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : LocalAuthDataSource {

    companion object AuthDataStoreKey {
        val ACCESS_TOKEN = stringPreferencesKey("access_token")
        val ACCESS_TIME = stringPreferencesKey("access_time")
        val REFRESH_TOKEN = stringPreferencesKey("refresh_token")
        val REFRESH_TIME = stringPreferencesKey("refresh_time")
    }

    override suspend fun getAccessToken(): Flow<String> = dataStore.data.map {
        it[ACCESS_TOKEN] ?: ""
    }

    override suspend fun setAccessToken(accessToken: String) {
        dataStore.edit {
            it[ACCESS_TOKEN] = accessToken
        }
    }

    override suspend fun deleteAccessToken() {
        dataStore.edit {
            it.remove(ACCESS_TOKEN)
        }
    }

    override suspend fun getAccessTime(): Flow<String> = dataStore.data.map {
        it[ACCESS_TIME] ?: ""
    }

    override suspend fun setAccessTime(accessToken: String) {
        dataStore.edit {
            it[ACCESS_TIME] = accessToken
        }
    }

    override suspend fun deleteAccessTime() {
        dataStore.edit {
            it.remove(ACCESS_TIME)
        }
    }

    override fun getRefreshToken(): Flow<String> = dataStore.data.map {
        it[REFRESH_TOKEN] ?: ""
    }

    override suspend fun setRefreshToken(refreshToken: String) {
        dataStore.edit {
            it[REFRESH_TOKEN] = refreshToken
        }
    }

    override suspend fun deleteRefreshToken() {
        dataStore.edit {
            it.remove(REFRESH_TOKEN)
        }
    }

    override suspend fun getRefreshTime(): Flow<String> = dataStore.data.map {
        it[REFRESH_TIME] ?: ""
    }

    override suspend fun setRefreshTime(refreshToken: String) {
        dataStore.edit {
            it[REFRESH_TIME] = refreshToken
        }
    }

    override suspend fun deleteRefreshTime() {
        dataStore.edit {
            it.remove(REFRESH_TIME)
        }
    }
}