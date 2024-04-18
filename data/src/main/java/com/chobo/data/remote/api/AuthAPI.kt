package com.chobo.data.remote.api

import com.chobo.data.remote.dto.auth.request.GAuthPostRequestBody
import com.chobo.data.remote.dto.auth.response.GAuthResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST

interface AuthAPI {
    @POST("/api/v2/auth")
    suspend fun gAuthPost(
        @Body body: GAuthPostRequestBody
    ): GAuthResponse

    @PATCH("/api/v2/auth")
    suspend fun gAuthPatch(
        @Header("RefreshToken") refreshToken: String,
    ): GAuthResponse

    @DELETE("/api/v2/auth")
    fun gAuthDelete()
}