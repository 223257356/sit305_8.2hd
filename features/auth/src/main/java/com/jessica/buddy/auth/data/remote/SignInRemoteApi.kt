package com.jessica.buddy.auth.data.remote

import com.jessica.buddy.core.data.model.UserData
import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.http.POST
import org.koin.core.annotation.Single

interface SignInRemoteApi {
    @POST("v1/auth/login/email")
    suspend fun emailSignIn(): UserData

    @POST("v1/auth/login/google")
    suspend fun googleSignIn(): UserData

    @POST("v1/auth/login/facebook")
    suspend fun facebookSignIn(): UserData

    @POST("v1/auth/login/apple")
    suspend fun appleSignIn(): UserData

    @POST("v1/auth/login/apple")
    suspend fun phoneSignIn(): UserData
}

@Single
internal class SignInRemoteApiImpl(ktorfit: Ktorfit) :
    SignInRemoteApi by ktorfit.createSignInRemoteApi()
