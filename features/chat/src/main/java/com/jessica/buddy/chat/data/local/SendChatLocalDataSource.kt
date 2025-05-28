package com.jessica.buddy.chat.data.local

import androidx.core.content.edit
import com.jessica.buddy.chat.data.model.ChatData
import com.jessica.buddy.core.data.local.LocalDataSource
import kotlinx.serialization.json.Json
import org.koin.core.annotation.Single
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

interface SendChatLocalDataSource {
    fun sendChat(isAi: Boolean, message: String): ChatData
}

@Single
internal class SendChatLocalDataSourceImpl(
    private val getChatLocalDataSource: GetChatLocalDataSource,
    private val localDataSource: LocalDataSource,
    private val json: Json
) : SendChatLocalDataSource {
    @OptIn(ExperimentalUuidApi::class)
    override fun sendChat(isAi: Boolean, message: String): ChatData {
        val currentChat = getChatLocalDataSource.getAllChats().getOrDefault(emptyList())
        val newChat = ChatData(id = Uuid.random().toString(), isAi = isAi, message = message)
        val updatedChat = currentChat.toMutableList().apply {
            add(newChat)
        }
        val rawJson = json.encodeToString(updatedChat)
        localDataSource.edit { putString(ChatLocalDataSource.CHAT_HISTORY_KEY, rawJson) }
        return newChat
    }
}
