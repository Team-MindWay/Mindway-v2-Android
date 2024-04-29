package com.chobo.domain.repository

import com.chobo.domain.model.auth.request.GAuthLoginRequestModel
import com.chobo.domain.model.auth.response.GAuthLoginResponseModel
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun gAuthLogin(body: GAuthLoginRequestModel): Flow<GAuthLoginResponseModel>
    suspend fun saveLoginData(data: GAuthLoginResponseModel)
    suspend fun logout(): Flow<Unit>
    suspend fun deleteLoginData()
}