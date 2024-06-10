package com.chobo.data.remote.dto.my_response

import com.chobo.domain.model.my.MyBookListModel
import com.google.gson.annotations.SerializedName

data class MyBookListResponse(
    val id: Long,
    val title: String,
    val author: String,
    @SerializedName("book_url")
    val bookUrl: String
)

fun MyBookListResponse.toModel() = MyBookListModel(
    id = id,
    title = title,
    author = author,
    bookUrl = bookUrl
)

fun MyBookListModel.toDto() = MyBookListResponse(
    id = id,
    title = title,
    author = author,
    bookUrl = bookUrl
)

