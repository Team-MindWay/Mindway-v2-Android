package com.chobo.data.remote.datasource.event

import com.chobo.data.remote.api.EventAPI
import com.chobo.data.remote.dto.event.response.*
import com.chobo.data.util.MindWayAPIHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
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