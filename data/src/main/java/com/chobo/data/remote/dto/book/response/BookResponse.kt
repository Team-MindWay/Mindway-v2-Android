package com.chobo.data.remote.dto.book.response

import com.google.gson.annotations.SerializedName

data class BookResponse(
    @SerializedName("item")
    val item:List<BookResponseListItem>
)