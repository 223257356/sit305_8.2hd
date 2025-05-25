package com.jessica.buddy.core.data.local.user

import com.jessica.buddy.core.data.local.LocalPrefGateway
import kotlinx.serialization.json.Json
import org.koin.core.annotation.Single

interface UserPrefGateway : SetUserDataGateway, GetUserDataGateway

@Single
internal class UserPrefGatewayImpl(
    private val localPrefGateway: LocalPrefGateway,
    private val json: Json
) : UserPrefGateway,
    SetUserDataGateway by SetUserDataGatewayImpl(
        localPrefGateway,
        json
    ),
    GetUserDataGateway by GetUserDataGatewayImpl(
        localPrefGateway,
        json
    )
