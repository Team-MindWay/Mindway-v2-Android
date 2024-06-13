package com.chobo.data.repository

import com.chobo.data.remote.datasource.event.RemoteEventDataSource
import com.chobo.data.remote.dto.event.response.toModel
import com.chobo.domain.model.event.response.GetDetailEventResponseModel
import com.chobo.domain.model.event.response.GetEventListResponseModel
import com.chobo.domain.repository.EventRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val remoteEventDataSource: RemoteEventDataSource
) : EventRepository {
    override suspend fun getEventList(status: String): Flow<List<GetEventListResponseModel>> =
        remoteEventDataSource.getEventList(status = status).map { list -> list.map { it.toModel() } }

    override suspend fun getDetailEvent(eventId: Long): Flow<GetDetailEventResponseModel> =
        remoteEventDataSource.getDetailEvent(eventId = eventId).map { it.toModel() }
}