package com.jessica.buddy.chat.data.remote

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.http.Field
import de.jensklingenberg.ktorfit.http.FormUrlEncoded
import de.jensklingenberg.ktorfit.http.POST
import org.koin.core.annotation.Single

interface ChatRemoteApi {
    @POST("chat")
    @FormUrlEncoded
    suspend fun chat(
        @Field("userMessage") userMessage: String
    ): String
}

@Single
internal class ChatRemoteApiImpl(ktorfit: Ktorfit) :
    ChatRemoteApi by ktorfit.createChatRemoteApi()
