package com.chobo.data.repository

import com.chobo.data.remote.datasource.event.RemoteEventDataSource
import com.chobo.data.remote.dto.event.response.toGetDetailEventResponseModel
import com.chobo.data.remote.dto.event.response.toGetEventDateListResponseModel
import com.chobo.data.remote.dto.event.response.toGetEventListResponseModel
import com.chobo.domain.model.event.response.GetDetailEventResponseModel
import com.chobo.domain.model.event.response.GetEventDateListResponseModel
import com.chobo.domain.model.event.response.GetEventListResponseModel
import com.chobo.domain.repository.EventRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val remoteEventDataSource: RemoteEventDataSource
): EventRepository {
    override suspend fun getEventList(status: String): Flow<List<GetEventListResponseModel>> {
        return remoteEventDataSource.getEventList(status = status).map { list ->
            list.map {
                it.toGetEventListResponseModel()
            }
        }
    }

    override suspend fun getDetailEvent(eventId: Long): Flow<GetDetailEventResponseModel> {
        return remoteEventDataSource.getDetailEvent(eventId = eventId).map { it.toGetDetailEventResponseModel() }
    }

    override suspend fun getEventDateList(date: String): Flow<List<GetEventDateListResponseModel>> {
        return remoteEventDataSource.getEventDateList(date = date).map { list ->
            list.map {
                it.toGetEventDateListResponseModel()
            }
        }
    }
}