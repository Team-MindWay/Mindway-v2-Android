package com.chobo.data.remote.datasource.event

import com.chobo.data.remote.api.EventAPI
import com.chobo.data.remote.dto.event.request.WriteEventRequest
import com.chobo.data.remote.dto.event.response.GetDetailEventResponse
import com.chobo.data.remote.dto.event.response.GetEventDateListResponse
import com.chobo.data.remote.dto.event.response.GetEventListResponse
import com.chobo.data.util.MindWayAPIHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.MultipartBody
import javax.inject.Inject

class RemoteEventDataSourceImpl @Inject constructor(
    private val eventService: EventAPI
): RemoteEventDataSource {
    override suspend fun getEventList(status: String): Flow<List<GetEventListResponse>> = flow {
        emit(
            MindWayAPIHandler<List<GetEventListResponse>>()
                .httpRequest {
                    eventService.getEventList(
                        status = status
                    )
                }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun getDetailEvent(eventId: Long): Flow<GetDetailEventResponse> = flow {
        emit(
            MindWayAPIHandler<GetDetailEventResponse>()
                .httpRequest {
                    eventService.getDetailEvent(
                        eventId = eventId
                    )
                }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun postWriteEvent(
        image: MultipartBody.Part,
        body: WriteEventRequest
    ): Flow<Unit> = flow {
        emit(
            MindWayAPIHandler<Unit>()
                .httpRequest {
                    eventService.postWriteEvent(
                        image = image,
                        body = body
                    )
                }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun deleteEvent(eventId: Long): Flow<Unit> = flow {
        emit(
            MindWayAPIHandler<Unit>()
                .httpRequest {
                    eventService.deleteEvent(
                        eventId = eventId
                    )
                }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun patchModifyEvent(
        image: MultipartBody.Part,
        eventId: Long,
        body: WriteEventRequest
    ): Flow<Unit> = flow {
        emit(
            MindWayAPIHandler<Unit>()
                .httpRequest {
                    eventService.patchModifyEvent(
                        image = image,
                        eventId = eventId,
                        body = body
                    )
                }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun getEventDateList(date: String): Flow<List<GetEventDateListResponse>> = flow {
        emit(
            MindWayAPIHandler<List<GetEventDateListResponse>>()
                .httpRequest {
                    eventService.getEventDate(
                        date = date
                    )
                }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}