package com.chobo.data.remote.dto.rank

import com.chobo.domain.model.rank.RankModel

data class RankResponse(
    val name: String,
    val accrue: Int
)

fun RankResponse.toModel() = RankModel(
    name = name,
    accrue = accrue,
)