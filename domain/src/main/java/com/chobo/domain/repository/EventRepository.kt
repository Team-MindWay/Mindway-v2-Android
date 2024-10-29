package com.chobo.domain.repository

import com.chobo.domain.model.event.response.GetDetailEventResponseModel
import com.chobo.domain.model.event.response.GetEventListResponseModel
import kotlinx.coroutines.flow.Flow

interface EventRepository {
     fun getEventList(status: String): Flow<List<GetEventListResponseModel>>
     fun getDetailEvent(eventId: Long): Flow<GetDetailEventResponseModel>
}