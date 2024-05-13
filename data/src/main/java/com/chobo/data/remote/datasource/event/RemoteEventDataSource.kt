package com.chobo.data.remote.datasource.event

import com.chobo.data.remote.dto.event.response.*
import kotlinx.coroutines.flow.Flow

interface RemoteEventDataSource {
    suspend fun getEventList(status: String): Flow<List<GetEventListResponse>>
    suspend fun getDetailEvent(eventId: Long): Flow<GetDetailEventResponse>
    suspend fun getEventDateList(date: String): Flow<List<GetEventDateListResponse>>
}