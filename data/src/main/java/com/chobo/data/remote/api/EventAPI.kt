package com.chobo.data.remote.api

import com.chobo.data.remote.dto.event.response.GetDetailEventResponse
import com.chobo.data.remote.dto.event.response.GetEventDateListResponse
import com.chobo.data.remote.dto.event.response.GetEventListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EventAPI {

    @GET("/api/v2/event")
    suspend fun getEventList(
        @Query("status") status: String
    ): List<GetEventListResponse>

    @GET("/api/v2/event/{event_id}")
    suspend fun getDetailEvent(
        @Path("event_id") eventId : Long
    ): GetDetailEventResponse

    @GET("/api/v2/event/date")
    suspend fun getEventDate(
        @Query("date") date: String
    ): List<GetEventDateListResponse>
}