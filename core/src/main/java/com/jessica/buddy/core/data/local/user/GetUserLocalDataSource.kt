package com.jessica.buddy.core.data.local.user

import com.jessica.buddy.core.data.local.LocalDataSource
import com.jessica.buddy.core.data.model.UserData
import com.jessica.buddy.core.domain.util.DomainConstant
import kotlinx.serialization.json.Json

interface GetUserLocalDataSource {
    fun getUserData(): Result<UserData>
}

internal class GetUserLocalDataSourceImpl(
    private val localDataSource: LocalDataSource,
    private val json: Json
) : GetUserLocalDataSource {
    override fun getUserData(): Result<UserData> {
        return runCatching {
            val rawData = localDataSource.getString(
                /* key = */
                DomainConstant.USER_DATA_PREF_KEY,
                /* defValue = */
                null
            ).orEmpty()
            json.decodeFromString(rawData)
        }
    }
}
