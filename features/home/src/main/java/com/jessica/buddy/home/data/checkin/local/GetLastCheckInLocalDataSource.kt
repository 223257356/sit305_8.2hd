package com.jessica.buddy.home.data.checkin.local

import com.jessica.buddy.core.data.local.LocalDataSource
import com.jessica.buddy.home.data.checkin.model.CheckInData
import kotlinx.serialization.json.Json
import org.koin.core.annotation.Single

interface GetLastCheckInLocalDataSource {
    fun getLastCheckIn(): Result<CheckInData>
}

@Single
internal class GetLastCheckInLocalDataSourceImpl(
    private val localDataSource: LocalDataSource,
    private val json: Json
) : GetLastCheckInLocalDataSource {

    override fun getLastCheckIn(): Result<CheckInData> {
        return runCatching {
            val rawData = localDataSource.getString(
                CheckInLocalDataSource.KEY_CHECK_IN,
                null
            ).orEmpty()
            requireNotNull(json.decodeFromString(rawData))
        }
    }
}
