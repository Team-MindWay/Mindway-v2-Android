package com.chobo.data.remote.dto.response.my

import com.google.gson.annotations.SerializedName

data class MyResponse(
    @SerializedName("name") val name: String,
    @SerializedName("authority") val authority: String,
)
