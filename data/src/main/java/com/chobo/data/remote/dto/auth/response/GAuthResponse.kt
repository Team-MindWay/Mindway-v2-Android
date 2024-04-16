package com.chobo.data.remote.dto.auth.response

import com.google.gson.annotations.SerializedName

data class GAuthResponse(
    @SerializedName("accessToken") val accessToken: String,
    @SerializedName("refreshToken") val refreshToken: String,
    @SerializedName("accessTokenExpiresIn") val accessTokenExpiresIn: String,
    @SerializedName("refreshTokenExpiresIn") val refreshTokenExpiresIn: String
)