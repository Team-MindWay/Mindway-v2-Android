package com.chobo.domain.model.my

import androidx.compose.runtime.Immutable

@Immutable
data class MyDataModel(
    val name: String,
    val authority: String,
)