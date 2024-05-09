package com.chobo.domain.repository

import com.chobo.domain.model.event.request.WriteEventRequestModel
import com.chobo.domain.model.event.response.GetDetailEventResponseModel
import com.chobo.domain.model.event.response.GetEventDateListResponseModel
import com.chobo.domain.model.event.response.GetEventListResponseModel
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody

interface EventRepository {
    suspend fun getEventList(status: String): Flow<List<GetEventListResponseModel>>
    suspend fun getDetailEvent(eventId: Long): Flow<GetDetailEventResponseModel>
    suspend fun postWriteEvent(image: MultipartBody.Part, body: WriteEventRequestModel): Flow<Unit>
    suspend fun deleteEvent(eventId: Long): Flow<Unit>
    suspend fun patchModifyEvent(image: MultipartBody.Part, eventId: Long, body: WriteEventRequestModel): Flow<Unit>
    suspend fun getEventDateList(date: String): Flow<List<GetEventDateListResponseModel>>
}