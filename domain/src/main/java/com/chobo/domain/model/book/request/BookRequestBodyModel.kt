package com.chobo.domain.model.book.request

import androidx.compose.runtime.Immutable

@Immutable
data class BookRequestBodyModel(
    val title: String,
    val plot: String
)
