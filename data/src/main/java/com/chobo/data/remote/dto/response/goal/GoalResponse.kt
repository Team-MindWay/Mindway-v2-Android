package com.chobo.data.remote.dto.response.goal

import com.google.gson.annotations.SerializedName

data class GoalResponse(
    @SerializedName("mon")
    val mon : Int,
    @SerializedName("tue")
    val tue : Int,
    @SerializedName("wed")
    val wed : Int,
    @SerializedName("thu")
    val thu : Int,
    @SerializedName("fri")
    val fri : Int,
    @SerializedName("sat")
    val sat : Int,
    @SerializedName("sun")
    val sun : Int,
    @SerializedName("now_count")
    val now_count : Int,
    @SerializedName("goal_value")
    val goal_value : Int,
)
