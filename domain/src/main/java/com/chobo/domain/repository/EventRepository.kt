package com.chobo.domain.repository

import com.chobo.domain.model.event.response.*
import kotlinx.coroutines.flow.Flow

interface EventRepository {
    suspend fun getEventList(status: String): Flow<List<GetEventListResponseModel>>
    suspend fun getDetailEvent(eventId: Long): Flow<GetDetailEventResponseModel>
    suspend fun getEventDateList(date: String): Flow<List<GetEventDateListResponseModel>>
}