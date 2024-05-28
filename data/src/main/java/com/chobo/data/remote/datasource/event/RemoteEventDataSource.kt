package com.chobo.data.remote.datasource.event

import com.chobo.data.remote.dto.event.response.GetDetailEventResponse
import com.chobo.data.remote.dto.event.response.GetEventListResponse
import kotlinx.coroutines.flow.Flow

interface RemoteEventDataSource {
    suspend fun getEventList(status: String): Flow<List<GetEventListResponse>>
    suspend fun getDetailEvent(eventId: Long): Flow<GetDetailEventResponse>
}