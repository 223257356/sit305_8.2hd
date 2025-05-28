package com.jessica.buddy.chat.data.local

import com.jessica.buddy.core.data.local.LocalDataSource
import kotlinx.serialization.json.Json
import org.koin.core.annotation.Single

interface ChatLocalDataSource : GetChatLocalDataSource, SendChatLocalDataSource {

    companion object {
        const val CHAT_HISTORY_KEY = "chat_history"
    }
}

@Single
internal class ChatLocalDataSourceImpl(
    private val localDataSource: LocalDataSource,
    private val json: Json,
    private val getChatLocalDataSource: GetChatLocalDataSource = GetChatLocalDataSourceImpl(
        localDataSource,
        json
    ),
) : ChatLocalDataSource,
    GetChatLocalDataSource by getChatLocalDataSource,
    SendChatLocalDataSource by SendChatLocalDataSourceImpl(
        getChatLocalDataSource,
        localDataSource,
        json
    )
