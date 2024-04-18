package com.chobo.data.remote.dto.rank_response

import com.google.gson.annotations.SerializedName

data class RankResponse(
    @SerializedName("username")
    val username: String,
    @SerializedName("total")
    val total: Int
)
