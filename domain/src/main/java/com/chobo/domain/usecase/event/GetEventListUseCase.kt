package com.chobo.domain.usecase.event

import com.chobo.domain.model.event.response.GetEventListResponseModel
import com.chobo.domain.repository.EventRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEventListUseCase @Inject constructor(
    private val eventRepository: EventRepository
) {
    suspend operator fun invoke(status: String): Flow<List<GetEventListResponseModel>> =
        eventRepository.getEventList(status = status)
}