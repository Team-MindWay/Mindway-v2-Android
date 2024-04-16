package com.chobo.data.remote.dto.request.goal

import com.google.gson.annotations.SerializedName

data class GoalGetResponseBody(
    @SerializedName("goal_count")
    val goal_count: Int
)
