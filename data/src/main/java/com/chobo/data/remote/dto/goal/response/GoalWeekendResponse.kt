package com.chobo.data.remote.dto.goal.response

import com.chobo.domain.model.goal.response.GetWeekendGoalModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoalWeekendResponse(
    @Json(name = "mon") val mon: Int,
    @Json(name = "tue") val tue: Int,
    @Json(name = "wed") val wed: Int,
    @Json(name = "thu") val thu: Int,
    @Json(name = "fri") val fri: Int,
    @Json(name = "sat") val sat: Int,
    @Json(name = "sun") val sun: Int,
    @Json(name = "now_count") val now_count: Int,
    @Json(name = "goal_value") val goal_value: Int,
)

fun GoalWeekendResponse.toModel() = GetWeekendGoalModel(
    mon = mon,
    tue = tue,
    wed = wed,
    thu = thu,
    fri = fri,
    sat = sat,
    sun = sun,
    now_count = now_count,
    goal_value = goal_value
)