package com.chobo.data.repository

import com.chobo.data.remote.datasource.event.RemoteEventDataSource
import com.chobo.data.remote.dto.event.request.toWriteEventRequest
import com.chobo.data.remote.dto.event.response.toGetDetailEventResponseModel
import com.chobo.data.remote.dto.event.response.toGetEventDateResponseModel
import com.chobo.data.remote.dto.event.response.toGetEventListResponseModel
import com.chobo.domain.model.event.request.WriteEventRequestModel
import com.chobo.domain.model.event.response.GetDetailEventResponseModel
import com.chobo.domain.model.event.response.GetEventDateResponseModel
import com.chobo.domain.model.event.response.GetEventListResponseModel
import com.chobo.domain.repository.EventRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import okhttp3.MultipartBody
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

    override suspend fun postWriteEvent(
        image: MultipartBody.Part,
        body: WriteEventRequestModel
    ): Flow<Unit> {
        return remoteEventDataSource.postWriteEvent(
            image = image,
            body = body.toWriteEventRequest()
        )
    }

    override suspend fun deleteEvent(eventId: Long): Flow<Unit> {
        return remoteEventDataSource.deleteEvent(eventId = eventId)
    }

    override suspend fun patchModifyEvent(
        image: MultipartBody.Part,
        eventId: Long,
        body: WriteEventRequestModel
    ): Flow<Unit> {
        return remoteEventDataSource.patchModifyEvent(
            image = image,
            eventId = eventId,
            body = body.toWriteEventRequest()
        )
    }

    override suspend fun getEventDate(date: String): Flow<List<GetEventDateResponseModel>> {
        return remoteEventDataSource.getEventDate(date = date).map { list ->
            list.map {
                it.toGetEventDateResponseModel()
            }
        }
    }
}