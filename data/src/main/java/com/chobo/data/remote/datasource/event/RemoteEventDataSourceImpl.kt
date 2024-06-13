package com.chobo.data.remote.datasource.event

import com.chobo.data.remote.api.EventAPI
import com.chobo.data.remote.dto.event.response.GetDetailEventResponse
import com.chobo.data.remote.dto.event.response.GetEventListResponse
import com.chobo.data.util.performApiRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteEventDataSourceImpl @Inject constructor(
    private val eventService: EventAPI
): RemoteEventDataSource {
    override suspend fun getEventList(status: String): Flow<List<GetEventListResponse>> = flow {
        performApiRequest { eventService.getEventList(status = status) }
    }

    override suspend fun getDetailEvent(eventId: Long): Flow<GetDetailEventResponse> = flow {
        performApiRequest { eventService.getDetailEvent(eventId = eventId) }
    }
}