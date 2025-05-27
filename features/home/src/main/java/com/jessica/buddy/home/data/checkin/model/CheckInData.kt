package com.jessica.buddy.home.data.checkin.model

import kotlinx.serialization.Serializable

@Serializable
data class CheckInData(
    val mood: Int,
    val sleepHours: Int,
    val submittedDate: Long
)
