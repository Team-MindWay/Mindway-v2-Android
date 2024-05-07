package com.chobo.domain.usecase.event

import com.chobo.domain.model.event.request.WriteEventRequestModel
import com.chobo.domain.repository.EventRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class PatchModifyEventUseCase @Inject constructor(
    private val eventRepository: EventRepository
) {
    suspend operator fun invoke(image: MultipartBody.Part, eventId: Long, body: WriteEventRequestModel) = runCatching {
        eventRepository.patchModifyEvent(
            image = image,
            eventId = eventId,
            body = body
        )
    }
}