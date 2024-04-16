package com.chobo.data.dto

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("refreshToken")
    val refreshToken: String,
    @SerializedName("accessTokenExpiresIn")
    val accessTokenExpiresIn: String,
    @SerializedName("refreshTokenExpiresIn")
    val refreshTokenExpiresIn: String
)