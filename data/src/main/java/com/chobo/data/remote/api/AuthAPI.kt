package com.chobo.data.remote.api

import com.chobo.data.remote.dto.auth.request.GAuthLoginRequestBody
import com.chobo.data.remote.dto.auth.response.GAuthLoginResponse
import retrofit2.http.*

interface AuthAPI {
    @POST("/api/v2/auth")
    suspend fun gAuthLogin(
        @Body body: GAuthLoginRequestBody
    ): GAuthLoginResponse

    @PATCH("/api/v2/auth")
    suspend fun gAuthAccess(
        @Header("refreshToken") refreshToken: String
    ): GAuthLoginResponse

    @DELETE("/api/v2/auth")
    fun gAuthLogout()
}