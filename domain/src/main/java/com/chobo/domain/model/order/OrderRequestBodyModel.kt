package com.chobo.domain.model.order

import androidx.compose.runtime.Immutable

@Immutable
data class OrderRequestBodyModel(
    val title: String,
    val author: String,
    val book_url: String,
)