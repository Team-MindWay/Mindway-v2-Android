package com.chobo.data.repository

import com.chobo.data.remote.datasource.event.RemoteEventDataSource
import com.chobo.data.remote.dto.event.response.*
import com.chobo.domain.model.event.response.*
import com.chobo.domain.repository.EventRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val remoteEventDataSource: RemoteEventDataSource
) : EventRepository {
    override suspend fun getEventList(status: String): Flow<List<GetEventListResponseModel>> {
        return remoteEventDataSource.getEventList(status = status)
            .map { list -> list.map { it.toModel() } }
    }

    override suspend fun getDetailEvent(eventId: Long): Flow<GetDetailEventResponseModel> {
        return remoteEventDataSource.getDetailEvent(eventId = eventId).map { it.toModel() }
    }

    override suspend fun getEventDateList(date: String): Flow<List<GetEventDateListResponseModel>> {
        return remoteEventDataSource.getEventDateList(date = date).map { list ->
            list.map { it.toModel() }
        }
    }
}