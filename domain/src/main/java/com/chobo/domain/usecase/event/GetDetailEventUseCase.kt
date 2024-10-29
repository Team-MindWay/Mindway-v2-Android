package com.chobo.domain.usecase.event

import com.chobo.domain.model.event.response.GetDetailEventResponseModel
import com.chobo.domain.repository.EventRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDetailEventUseCase @Inject constructor(
    private val eventRepository: EventRepository
) {
     operator fun invoke(eventId: Long): Flow<GetDetailEventResponseModel> =
        eventRepository.getDetailEvent(eventId = eventId)
}