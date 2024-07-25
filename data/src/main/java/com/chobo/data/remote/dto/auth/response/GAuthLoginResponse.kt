package com.chobo.data.remote.dto.auth.response

import com.chobo.domain.model.auth.response.GAuthLoginResponseModel

data class GAuthLoginResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExpiresIn: String,
    val refreshTokenExpiresIn: String
)

fun GAuthLoginResponse.toLoginModel() = GAuthLoginResponseModel(
    accessToken = accessToken,
    refreshToken = refreshToken,
    accessTokenExpiresIn = accessTokenExpiresIn,
    refreshTokenExpiresIn = refreshTokenExpiresIn
)