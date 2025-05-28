package com.jessica.buddy.chat.data.local

import com.jessica.buddy.chat.data.model.ChatData
import com.jessica.buddy.core.data.local.LocalDataSource
import kotlinx.serialization.json.Json
import org.koin.core.annotation.Single

interface GetChatLocalDataSource {
    fun getAllChats(): Result<List<ChatData>>
}

@Single
internal class GetChatLocalDataSourceImpl(
    private val localDataSource: LocalDataSource,
    private val json: Json
) : GetChatLocalDataSource {
    override fun getAllChats(): Result<List<ChatData>> {
        return runCatching {
            val rawData = localDataSource.getString(
                ChatLocalDataSource.CHAT_HISTORY_KEY,
                null
            ).orEmpty()
            json.decodeFromString(rawData)
        }
    }
}
