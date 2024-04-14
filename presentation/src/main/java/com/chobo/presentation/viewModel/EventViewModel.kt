package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.chobo.presentation.view.event.component.EventsData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor() : ViewModel() {
    private val _currentEventsDataList = MutableStateFlow(
        listOf(
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),

            )
    )
    val currentEventsDataList: StateFlow<List<EventsData>> = _currentEventsDataList.asStateFlow()

    private val _pastEventsDataList = MutableStateFlow(
        listOf(
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),
            EventsData(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 ",
                date = "2024년 04월 08일"
            ),

            )
    )
    val pastEventsDataList: StateFlow<List<EventsData>> = _pastEventsDataList.asStateFlow()

    fun onCurrentIconClick(index: Int) {

    }

    fun onPastIconClick(index: Int) {

    }
}