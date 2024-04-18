package com.chobo.presentation.view.util

import com.chobo.domain.excption.BadRequestException
import com.chobo.domain.excption.ConflictException
import com.chobo.domain.excption.ForBiddenException
import com.chobo.domain.excption.NotFoundException
import com.chobo.domain.excption.OtherHttpException
import com.chobo.domain.excption.ServerException
import com.chobo.domain.excption.TimeOutException

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