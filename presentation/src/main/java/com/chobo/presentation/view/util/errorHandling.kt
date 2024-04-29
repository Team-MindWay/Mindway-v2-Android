package com.chobo.presentation.view.util

import com.chobo.domain.exception.BadRequestException
import com.chobo.domain.exception.ConflictException
import com.chobo.domain.exception.ForBiddenException
import com.chobo.domain.exception.NotFoundException
import com.chobo.domain.exception.OtherHttpException
import com.chobo.domain.exception.ServerException
import com.chobo.domain.exception.TimeOutException

fun Throwable.errorHandler(
    badRequestAction: () -> Unit = {},
    forbiddenAction: () -> Unit = {},
    notFoundAction: () -> Unit = {},
    timeOutAction: () -> Unit = {},
    conflictAction: () -> Unit = {},
    serverAction: () -> Unit = {},
    otherHttpAction: () -> Unit = {},
    unknownAction: () -> Unit = {},
) {
    when (this) {
        is BadRequestException -> badRequestAction()
        is ForBiddenException -> forbiddenAction()
        is NotFoundException -> notFoundAction()
        is TimeOutException -> timeOutAction()
        is ConflictException -> conflictAction()
        is ServerException -> serverAction()
        is OtherHttpException -> otherHttpAction()
        else -> unknownAction()
    }
}