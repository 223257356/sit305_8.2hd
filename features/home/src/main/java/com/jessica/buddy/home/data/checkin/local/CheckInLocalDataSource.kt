package com.jessica.buddy.home.data.checkin.local

import java.util.concurrent.TimeUnit
import java.util.Calendar

import com.jessica.buddy.core.data.local.LocalDataSource
import kotlinx.serialization.json.Json
import org.koin.core.annotation.Single

interface CheckInLocalDataSource : GetLastCheckInLocalDataSource, SetLastCheckInLocalDataSource {

    fun shouldShowCheckIn(): Boolean

    companion object {
        const val KEY_CHECK_IN = "key_check_in"
    }
}

@Single
internal class CheckInLocalDataSourceImpl(
    private val localDataSource: LocalDataSource,
    private val json: Json
) : CheckInLocalDataSource,
    GetLastCheckInLocalDataSource by GetLastCheckInLocalDataSourceImpl(localDataSource, json),
    SetLastCheckInLocalDataSource by SetLastCheckInLocalDataSourceImpl(
        localDataSource,
        json
    ) {
    override fun shouldShowCheckIn(): Boolean {
        val lastCheckIn = getLastCheckIn().getOrNull()
        return if (lastCheckIn == null) {
            true
        } else {
            val currentTimeMillis = Calendar.getInstance().timeInMillis
            val submittedDateMillis = lastCheckIn.submittedDate
            val timeDifferenceMillis = currentTimeMillis - submittedDateMillis
            val oneDayInMillis = TimeUnit.DAYS.toMillis(1)
            timeDifferenceMillis >= oneDayInMillis
        }
    }
}
