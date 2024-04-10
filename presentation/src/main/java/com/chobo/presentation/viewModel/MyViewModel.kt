package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.chobo.presentation.view.main.screen.MockOnClick
import com.chobo.presentation.view.my.component.MyBookListItemData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor() : ViewModel() {
    private val _myBookListItemDataList = listOf(
        MyBookListItemData(
            title = "제목입니다",
            writer = "작가입니다",
            editOnclick = { MockOnClick() },
            trashCanOnclick = { MockOnClick() }),
        MyBookListItemData(
            title = "dqwdqwd",
            writer = "작가입니다",
            editOnclick = { MockOnClick() },
            trashCanOnclick = { MockOnClick() }),
        MyBookListItemData(
            title = "제목입니다",
            writer = "작가입니다",
            editOnclick = { MockOnClick() },
            trashCanOnclick = { MockOnClick() }),
        MyBookListItemData(
            title = "제목입dqwdqw니다",
            writer = "작dqw가입니다",
            editOnclick = { MockOnClick() },
            trashCanOnclick = { MockOnClick() }),
        MyBookListItemData(
            title = "제목입니다",
            writer = "작가입dqw니다",
            editOnclick = { MockOnClick() },
            trashCanOnclick = { MockOnClick() }),
        MyBookListItemData(
            title = "제목입니다",
            writer = "작가입니다",
            editOnclick = { MockOnClick() },
            trashCanOnclick = { MockOnClick() }),
        MyBookListItemData(
            title = "dwq",
            writer = "작가입니다",
            editOnclick = { MockOnClick() },
            trashCanOnclick = { MockOnClick() }),
        MyBookListItemData(
            title = "제목입니다",
            writer = "작가입dqwd니다",
            editOnclick = { MockOnClick() },
            trashCanOnclick = { MockOnClick() }),
        MyBookListItemData(
            title = "제목입니다",
            writer = "작가입니다",
            editOnclick = { MockOnClick() },
            trashCanOnclick = { MockOnClick() }),
        MyBookListItemData(
            title = "제목입dqwdqw니다",
            writer = "작가dqwdqw입니다",
            editOnclick = { MockOnClick() },
            trashCanOnclick = { MockOnClick() }),
        MyBookListItemData(
            title = "제목입dqwd니다",
            writer = "작가입dqwdwq다",
            editOnclick = { MockOnClick() },
            trashCanOnclick = { MockOnClick() }),
    )
    val myBookListItemDataList = _myBookListItemDataList

    private val _myName = "내이름"

    fun returnMyName(): String {
        return _myName
    }

    fun optionOnClick() {

    }
}