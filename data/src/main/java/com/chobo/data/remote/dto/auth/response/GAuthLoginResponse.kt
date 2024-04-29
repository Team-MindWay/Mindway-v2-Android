package com.chobo.data.remote.dto.auth.response

import com.chobo.domain.model.auth.response.GAuthLoginResponseModel
import com.google.gson.annotations.SerializedName

data class GAuthLoginResponse(
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("refreshToken")
    val refreshToken: String,
    @SerializedName("accessTokenExpiresIn")
    val accessTokenExpiresIn: String,
    @SerializedName("refreshTokenExpiresIn")
    val refreshTokenExpiresIn: String
)

fun GAuthLoginResponse.toLoginModel() = GAuthLoginResponseModel(
    accessToken = this.accessToken,
    refreshToken = this.refreshToken,
    accessTokenExpiresIn = this.accessTokenExpiresIn,
    refreshTokenExpiresIn = this.refreshTokenExpiresIn
)