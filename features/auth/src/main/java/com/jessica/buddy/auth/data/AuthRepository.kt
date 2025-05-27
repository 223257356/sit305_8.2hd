package com.jessica.buddy.auth.data

import com.jessica.buddy.auth.data.remote.SignInRemoteApi
import com.jessica.buddy.core.data.local.user.UserLocalDataSource
import com.jessica.buddy.core.data.model.UserData
import org.koin.core.annotation.Single

interface AuthRepository {
    suspend fun signIn(apiCall: suspend SignInRemoteApi.() -> UserData): Result<UserData>
}

@Single
internal class AuthRepositoryImpl(
    private val signInRemoteApi: SignInRemoteApi,
    private val userPrefGateway: UserLocalDataSource
) : AuthRepository {
    override suspend fun signIn(apiCall: suspend SignInRemoteApi.() -> UserData): Result<UserData> {
        // TODO: Remove this if already using correct backend
        val response = runCatching {
            apiCall(signInRemoteApi)
        }.getOrElse { UserData.mocked() }
        return signInRemoteApi.runCatching {
            // TODO: Remove this if already using correct backend
            // apiCall()
            response
        }.onSuccess {
            userPrefGateway.setUserData(it)
        }
    }
}
