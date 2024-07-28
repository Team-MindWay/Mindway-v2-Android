package com.chobo.data.remote.dto.auth.request

import com.chobo.domain.model.auth.request.GAuthLoginRequestModel

data class GAuthLoginRequestBody(
    val code: String
)

fun GAuthLoginRequestModel.toDto() = GAuthLoginRequestBody(code = code)