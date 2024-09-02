package com.chobo.data.remote.dto.auth.response

import com.chobo.domain.model.auth.response.GAuthLoginResponseModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GAuthLoginResponse(
    @Json(name = "accessToken") val accessToken: String,
    @Json(name = "refreshToken") val refreshToken: String,
    @Json(name = "accessTokenExpiresIn") val accessTokenExpiresIn: String,
    @Json(name = "refreshTokenExpiresIn") val refreshTokenExpiresIn: String
)

fun GAuthLoginResponse.toLoginModel() = GAuthLoginResponseModel(
    accessToken = accessToken,
    refreshToken = refreshToken,
    accessTokenExpiresIn = accessTokenExpiresIn,
    refreshTokenExpiresIn = refreshTokenExpiresIn
)