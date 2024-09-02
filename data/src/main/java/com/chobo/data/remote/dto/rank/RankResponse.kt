package com.chobo.data.remote.dto.rank

import com.chobo.domain.model.rank.RankModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RankResponse(
    @Json(name = "name") val name: String,
    @Json(name = "accrue") val accrue: Int
)

fun RankResponse.toModel() = RankModel(
    name = name,
    accrue = accrue,
)