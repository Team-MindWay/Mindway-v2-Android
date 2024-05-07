package com.chobo.data.remote.api

import com.chobo.data.remote.dto.event.request.WriteEventRequest
import com.chobo.data.remote.dto.event.response.GetDetailEventResponse
import com.chobo.data.remote.dto.event.response.GetEventDateResponse
import com.chobo.data.remote.dto.event.response.GetEventListResponse
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Part
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

    @Multipart
    @POST("/api/v2/event")
    suspend fun postWriteEvent(
        @Part image: MultipartBody.Part?,
        @Body body: WriteEventRequest
    )

    @DELETE("/api/v2/event/{event_id}")
    suspend fun deleteEvent(
        @Path("event_id") eventId: Long
    )

    @Multipart
    @PATCH("/api/v2/event/{event_id}")
    suspend fun patchModifyEvent(
        @Part image: MultipartBody.Part?,
        @Body body: WriteEventRequest,
        @Path("event_id") eventId: Long
    )

    @GET("/api/v2/event/date")
    suspend fun getEventDate(
        @Query("date") date: String
    ): List<GetEventDateResponse>
}