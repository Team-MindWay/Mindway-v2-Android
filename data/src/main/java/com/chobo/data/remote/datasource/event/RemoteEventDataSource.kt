package com.chobo.data.remote.datasource.event

import com.chobo.data.remote.dto.event.request.WriteEventRequest
import com.chobo.data.remote.dto.event.response.GetDetailEventResponse
import com.chobo.data.remote.dto.event.response.GetEventDateResponse
import com.chobo.data.remote.dto.event.response.GetEventListResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody

interface RemoteEventDataSource {
    suspend fun getEventList(status: String): Flow<List<GetEventListResponse>>
    suspend fun getDetailEvent(eventId: Long): Flow<GetDetailEventResponse>
    suspend fun postWriteEvent(image: MultipartBody.Part, body: WriteEventRequest): Flow<Unit>
    suspend fun deleteEvent(eventId: Long): Flow<Unit>
    suspend fun patchModifyEvent(image: MultipartBody.Part, eventId: Long, body: WriteEventRequest): Flow<Unit>
    suspend fun getEventDate(date: String): Flow<List<GetEventDateResponse>>
}