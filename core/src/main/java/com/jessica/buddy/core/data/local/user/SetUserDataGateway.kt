package com.jessica.buddy.core.data.local.user

import androidx.core.content.edit
import com.jessica.buddy.core.data.local.LocalPrefGateway
import com.jessica.buddy.core.data.model.UserData
import com.jessica.buddy.core.domain.util.DomainConstant
import kotlinx.serialization.json.Json

interface SetUserDataGateway {
    fun setUserData(userData: UserData)
}

internal class SetUserDataGatewayImpl(
    private val localPrefGateway: LocalPrefGateway,
    private val json: Json
) : SetUserDataGateway {
    override fun setUserData(userData: UserData) {
        val jsonString = json.encodeToString(userData)
        localPrefGateway.edit {
            putString(DomainConstant.USER_DATA_PREF_KEY, jsonString)
        }
    }
}
