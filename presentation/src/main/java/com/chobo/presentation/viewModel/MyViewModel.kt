package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.chobo.presentation.view.my.component.MyBookListItemData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor() : ViewModel() {
    private val _myBookListItemDataList = MutableStateFlow(
        listOf(
            MyBookListItemData(
                title = "제목입니다",
                writer = "작가입dqwd니다",
                editOnclick = { },
                trashCanOnclick = { }),
            MyBookListItemData(
                title = "제목입니다",
                writer = "작가입니다",
                editOnclick = { },
                trashCanOnclick = { }),
            MyBookListItemData(
                title = "제목입dqwdqw니다",
                writer = "작가dqwdqw입니다",
                editOnclick = { },
                trashCanOnclick = { }),
            MyBookListItemData(
                title = "제목입dqwd니다",
                writer = "작가입dqwdwq다",
                editOnclick = { },
                trashCanOnclick = { }),
            MyBookListItemData(
                title = "제목입니다",
                writer = "작가입dqwd니다",
                editOnclick = { },
                trashCanOnclick = { }),
            MyBookListItemData(
                title = "제목입니다",
                writer = "작가입니다",
                editOnclick = { },
                trashCanOnclick = { }),
            MyBookListItemData(
                title = "제목입dqwdqw니다",
                writer = "작가dqwdqw입니다",
                editOnclick = { },
                trashCanOnclick = { }),
            MyBookListItemData(
                title = "제목입dqwd니다",
                writer = "작가입dqwdwq다",
                editOnclick = { },
                trashCanOnclick = { }),
            MyBookListItemData(
                title = "제목입니다",
                writer = "작가입dqwd니다",
                editOnclick = { },
                trashCanOnclick = { }),
            MyBookListItemData(
                title = "제목입니다",
                writer = "작가입니다",
                editOnclick = { },
                trashCanOnclick = { }),
            MyBookListItemData(
                title = "제목입dqwdqw니다",
                writer = "작가dqwdqw입니다",
                editOnclick = { },
                trashCanOnclick = { }),
            MyBookListItemData(
                title = "제목입dqwd니다",
                writer = "작가입dqwdwq다",
                editOnclick = { },
                trashCanOnclick = { }),
            MyBookListItemData(
                title = "제목입니다",
                writer = "작가입dqwd니다",
                editOnclick = { },
                trashCanOnclick = { }),
            MyBookListItemData(
                title = "제목입니다",
                writer = "작가입니다",
                editOnclick = { },
                trashCanOnclick = { }),
            MyBookListItemData(
                title = "제목입dqwdqw니다",
                writer = "작가dqwdqw입니다",
                editOnclick = { },
                trashCanOnclick = { }),
            MyBookListItemData(
                title = "제목입dqwd니다",
                writer = "작가입dqwdwq다",
                editOnclick = { },
                trashCanOnclick = { }),
        )
    )
    val myBookListItemDataList : StateFlow<List<MyBookListItemData>> = _myBookListItemDataList.asStateFlow()

    private val _myName = MutableStateFlow("내이름")
    val myName :StateFlow<String> = _myName.asStateFlow()

    fun optionOnClick() {

    }
}