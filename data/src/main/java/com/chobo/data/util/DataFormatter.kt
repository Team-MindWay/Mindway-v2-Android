package com.chobo.data.util

import android.annotation.SuppressLint
import com.chobo.domain.exception.NeedLoginException
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
fun String.toDate(): Date {
    kotlin.runCatching {
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(this)!!
    }.onSuccess {
        return it
    }
    throw NeedLoginException()
}

@SuppressLint("SimpleDateFormat")
fun Long.toMindWayDate(): Date {
    return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(this).toDate()
}