package com.chobo.data.remote.dto.request.auth

import com.google.gson.annotations.SerializedName

data class GAuthPostRequestBody(
    @SerializedName("code") val code: String
)
