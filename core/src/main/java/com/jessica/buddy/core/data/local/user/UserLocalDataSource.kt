package com.jessica.buddy.core.data.local.user

import com.jessica.buddy.core.data.local.LocalDataSource
import kotlinx.serialization.json.Json
import org.koin.core.annotation.Single

interface UserLocalDataSource : SetUserLocalDataSource, GetUserLocalDataSource

@Single
internal class UserLocalDataSourceImpl(
    private val localDataSource: LocalDataSource,
    private val json: Json
) : UserLocalDataSource,
    SetUserLocalDataSource by SetUserLocalDataSourceImpl(
        localDataSource,
        json
    ),
    GetUserLocalDataSource by GetUserLocalDataSourceImpl(
        localDataSource,
        json
    )
