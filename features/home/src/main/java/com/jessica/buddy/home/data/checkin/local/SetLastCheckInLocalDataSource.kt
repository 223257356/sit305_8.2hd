package com.jessica.buddy.home.data.checkin.local

import androidx.core.content.edit
import com.jessica.buddy.core.data.local.LocalDataSource
import com.jessica.buddy.home.data.checkin.model.CheckInData
import kotlinx.serialization.json.Json
import org.koin.core.annotation.Single

interface SetLastCheckInLocalDataSource {
    fun checkIn(checkInData: CheckInData)
}

@Single
internal class SetLastCheckInLocalDataSourceImpl(
    private val localDataSource: LocalDataSource,
    private val json: Json
) : SetLastCheckInLocalDataSource {
    override fun checkIn(checkInData: CheckInData) {
        val rawJson = json.encodeToString(checkInData)
        localDataSource.edit { putString(CheckInLocalDataSource.KEY_CHECK_IN, rawJson) }
    }
}
