package com.chobo.domain.model.auth.response

import androidx.compose.runtime.Immutable

@Immutable
data class GAuthLoginResponseModel(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExpiresIn: String,
    val refreshTokenExpiresIn: String
)