package com.chobo.domain.model.auth.request

import androidx.compose.runtime.Immutable

@Immutable
data class GAuthLoginRequestModel(
    val code: String
)