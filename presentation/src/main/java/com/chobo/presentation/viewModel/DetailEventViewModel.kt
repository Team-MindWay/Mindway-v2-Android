package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.chobo.presentation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailEventViewModel @Inject constructor() : ViewModel() {
    private val _title = "가을 독서 행사"
    fun returnTitle(): String {
        return _title
    }

    private val _content =
        "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를 준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 책을 찾아오면 푸짐한 선물뽑기를 할 수 있습니다. 점심시간마다 진행할 예정이니 많은 관심 바랍니다."

    fun returnContent(): String {
        return _content
    }

    private val _date = "2023년 06월 20일 ~ 2023년 07월 08일"
    fun returnDate(): String {
        return _date
    }

    private val _imageResId = R.drawable.mind_way_logo

    fun returnImageResId(): Int {
        return _imageResId
    }
}
