package com.chobo.data.remote.api

import com.chobo.data.remote.dto.auth.request.GAuthPostRequestBody
import com.chobo.data.remote.dto.auth.response.GAuthResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST

interface AuthAPI {
    @POST("/api/v2/auth")
    suspend fun gAuthPost(
        @Header("Authorization") authorization: String,
        @Body body: GAuthPostRequestBody
    ): Call<GAuthResponse>

    @PATCH("/api/v2/auth")
    suspend fun gAuthPatch(
        @Header("refreshToken") refreshToken: String,
    ): Call<GAuthResponse>

    @DELETE("/api/v2/auth")
    suspend fun gAuthDelete(
        @Header("refreshToken") refreshToken: String,
    )
}