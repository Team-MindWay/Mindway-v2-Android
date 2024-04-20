package com.chobo.data.remote.api

import com.chobo.data.remote.dto.event.response.EventListResponse
import retrofit2.http.GET

interface EventAPI {
    @GET("/api/v2/event")
    suspend fun getEventList(): List<EventListResponse>

    //@GET("/api/v2/event/{event_id}")
}