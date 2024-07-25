package com.chobo.data.util

import com.chobo.domain.exception.NeedLoginException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())

fun String.toDate() = runCatching {
    dateFormat.parse(this)
}.getOrElse {
    throw NeedLoginException()
} ?: throw NeedLoginException()

fun getDate() = dateFormat.format(Calendar.getInstance().time).toDate()