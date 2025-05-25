package com.jessica.buddy.core.data.local.user

import com.jessica.buddy.core.data.local.LocalPrefGateway
import com.jessica.buddy.core.data.model.UserData
import com.jessica.buddy.core.domain.util.DomainConstant
import kotlinx.serialization.json.Json

interface GetUserDataGateway {
    fun getUserData(): Result<UserData>
}

internal class GetUserDataGatewayImpl(
    private val localPrefGateway: LocalPrefGateway,
    private val json: Json
) : GetUserDataGateway {
    override fun getUserData(): Result<UserData> {
        return runCatching {
            val rawData = localPrefGateway.getString(
                /* key = */
                DomainConstant.USER_DATA_PREF_KEY,
                /* defValue = */
                null
            ).orEmpty()
            json.decodeFromString(rawData)
        }
    }
}
