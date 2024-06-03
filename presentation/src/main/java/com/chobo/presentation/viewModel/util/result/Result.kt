package com.chobo.presentation.viewModel.util.result

import kotlinx.coroutines.flow.*

sealed interface Result<out T> {
    data class Success<T>(val data: T): Result<T>
    data class Fail(val exception: Throwable): Result<Nothing>
    object Loading: Result<Nothing>
}

fun <T> Flow<T>.asResult(): Flow<Result<T>> = map<T, Result<T>> { Result.Success(it) }
    .onStart { emit(Result.Loading) }
    .catch { emit(Result.Fail(it)) }