package com.chobo.data.remote.api

import com.chobo.data.remote.dto.request.auth.GAuthPostRequestBody
import com.chobo.data.remote.dto.response.auth.GAuthResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST

interface AuthApi {
    @POST("/api/v2/auth")
    fun gAuthPost(
        @Header("Authorization") authorization: String,
        @Body body: GAuthPostRequestBody
    ): Call<GAuthResponse>

    @PATCH("/api/v2/auth")
    fun gAuthPatch(
        @Header("refreshToken") refreshToken: String,
    ): Call<GAuthResponse>

    @DELETE("/api/v2/auth")
    fun gAuthDelete(
        @Header("refreshToken") refreshToken: String,
    )
}