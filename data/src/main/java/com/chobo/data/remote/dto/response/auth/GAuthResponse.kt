package com.chobo.data.remote.dto.response.auth

import com.google.gson.annotations.SerializedName

data class GAuthResponse(
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("refreshToken")
    val refreshToken: String,
    @SerializedName("accessTokenExpiresIn")
    val accessTokenExpiresIn: String,
    @SerializedName("refreshTokenExpiresIn")
    val refreshTokenExpiresIn: String
)