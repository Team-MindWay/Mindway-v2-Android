package com.chobo.data.remote.dto.rank

import com.chobo.domain.model.rank.RankModel

data class RankResponse(
    val username: String,
    val total: String
)

fun RankResponse.toModel(): RankModel = RankModel(
    username = username,
    total = total,
)
