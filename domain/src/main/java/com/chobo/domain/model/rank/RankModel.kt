package com.chobo.domain.model.rank

import androidx.compose.runtime.Immutable

@Immutable
data class RankModel(
    val name: String,
    val accrue: Int
)