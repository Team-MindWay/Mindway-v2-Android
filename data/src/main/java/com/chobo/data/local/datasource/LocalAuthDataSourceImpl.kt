package com.chobo.data.local.datasource

import android.util.Log
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

    override fun getAccessToken(): Flow<String> = dataStore.data.map {
        Log.d(ACCESS_TOKEN.toString(), it[ACCESS_TOKEN] ?: "")
        it[ACCESS_TOKEN] ?: ""
    }

    override suspend fun setAccessToken(accessToken: String) {
        dataStore.edit {
            Log.d("set $ACCESS_TOKEN", accessToken)
            it[ACCESS_TOKEN] = accessToken
        }
    }

    override suspend fun deleteAccessToken() {
        dataStore.edit {
            Log.d("delete $ACCESS_TOKEN", "dleele")
            it.remove(ACCESS_TOKEN)
        }
    }

    override fun getAccessTime(): Flow<String> = dataStore.data.map {
        Log.d("$ACCESS_TIME", it[ACCESS_TIME] ?: "")
        it[ACCESS_TIME] ?: ""
    }

    override suspend fun setAccessTime(accessTime: String) {
        dataStore.edit {
            Log.d("set $ACCESS_TIME", accessTime)
            it[ACCESS_TIME] = accessTime
        }
    }

    override suspend fun deleteAccessTime() {
        dataStore.edit {
            Log.d("delete $ACCESS_TIME", "dleele")
            it.remove(ACCESS_TIME)
        }
    }

    override fun getRefreshToken(): Flow<String> = dataStore.data.map {
        Log.d(REFRESH_TOKEN.toString(), it[REFRESH_TOKEN] ?: "")
        it[REFRESH_TOKEN] ?: ""
    }

    override suspend fun setRefreshToken(refreshToken: String) {
        dataStore.edit {
            Log.d("set $REFRESH_TOKEN", refreshToken)
            it[REFRESH_TOKEN] = refreshToken
        }
    }

    override suspend fun deleteRefreshToken() {
        dataStore.edit {
            Log.d("delete $REFRESH_TOKEN", "dleele")
            it.remove(REFRESH_TOKEN)
        }
    }

    override fun getRefreshTime(): Flow<String> = dataStore.data.map {
        Log.d(REFRESH_TIME.toString(), it[REFRESH_TIME] ?: "")
        it[REFRESH_TIME] ?: ""
    }

    override suspend fun setRefreshTime(refreshTime: String) {
        dataStore.edit {
            Log.d("set $REFRESH_TIME", refreshTime)
            it[REFRESH_TIME] = refreshTime
        }
    }

    override suspend fun deleteRefreshTime() {
        dataStore.edit {
            Log.d("delete $REFRESH_TIME", "dleele")
            it.remove(REFRESH_TIME)
        }
    }
}
