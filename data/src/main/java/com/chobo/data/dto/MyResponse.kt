package com.chobo.data.dto

import com.google.gson.annotations.SerializedName

data class MyResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("authority")
    val authority: String,
)
