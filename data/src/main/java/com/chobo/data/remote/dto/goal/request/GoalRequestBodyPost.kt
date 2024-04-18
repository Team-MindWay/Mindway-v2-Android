package com.chobo.data.remote.dto.goal.request

import com.google.gson.annotations.SerializedName

data class GoalRequestBodyPost(
    @SerializedName("goal_count")
    val goal_count: Int
)