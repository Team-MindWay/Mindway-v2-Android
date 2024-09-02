package com.chobo.data.remote.dto.auth.request

import com.chobo.domain.model.auth.request.GAuthLoginRequestModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GAuthLoginRequestBody(
    @Json(name = "code") val code: String
)

fun GAuthLoginRequestModel.toDto() = GAuthLoginRequestBody(code = code)