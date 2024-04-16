package com.chobo.data.remote.dto.auth.request

import com.google.gson.annotations.SerializedName

data class GAuthPostRequestBody(
    @SerializedName("code") val code: String
)
