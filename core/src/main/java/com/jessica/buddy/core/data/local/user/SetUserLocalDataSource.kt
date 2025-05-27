package com.jessica.buddy.core.data.local.user

import androidx.core.content.edit
import com.jessica.buddy.core.data.local.LocalDataSource
import com.jessica.buddy.core.data.model.UserData
import com.jessica.buddy.core.domain.util.DomainConstant
import kotlinx.serialization.json.Json

interface SetUserLocalDataSource {
    fun setUserData(userData: UserData)
}

internal class SetUserLocalDataSourceImpl(
    private val localDataSource: LocalDataSource,
    private val json: Json
) : SetUserLocalDataSource {
    override fun setUserData(userData: UserData) {
        val jsonString = json.encodeToString(userData)
        localDataSource.edit {
            putString(DomainConstant.USER_DATA_PREF_KEY, jsonString)
        }
    }
}
