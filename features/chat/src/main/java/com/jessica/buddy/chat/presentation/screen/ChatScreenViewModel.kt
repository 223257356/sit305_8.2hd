package com.jessica.buddy.chat.presentation.screen

import androidx.lifecycle.ViewModel
import com.jessica.buddy.chat.data.local.ChatLocalDataSource
import com.jessica.buddy.chat.data.model.ChatData
import com.jessica.buddy.chat.data.remote.ChatRemoteApi
import org.koin.android.annotation.KoinViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

data class ChatScreenState(
    val chatList: List<ChatData> = emptyList(),
    val isAiTyping: Boolean = false,
    val chatMessage: String = ""
)

sealed interface ChatScreenEvent {
    data class SendMessage(val message: String) : ChatScreenEvent
    data class OnMessageChange(val message: String) : ChatScreenEvent
}

@KoinViewModel
class ChatScreenViewModel(
    private val chatLocalDataSource: ChatLocalDataSource,
    private val chatRemoteApi: ChatRemoteApi
) : ViewModel(), ContainerHost<ChatScreenState, ChatScreenEvent> {
    override val container: Container<ChatScreenState, ChatScreenEvent> = container(
        ChatScreenState(chatList = chatLocalDataSource.getAllChats().getOrDefault(emptyList()))
    )

    fun onEvent(event: ChatScreenEvent) = intent {
        when (event) {
            is ChatScreenEvent.SendMessage -> {
                val newMessage = chatLocalDataSource.sendChat(false, event.message)
                reduce {
                    state.copy(
                        chatList = state.chatList.toMutableList().apply {
                            add(newMessage)
                        },
                        isAiTyping = true
                    )
                }
                val aiResponse = kotlin.runCatching {
                    chatRemoteApi.chat(event.message)
                }.getOrElse {
                    MockedAiChatResponse.getRandom()
                }
                val aiMessage = chatLocalDataSource.sendChat(true, aiResponse)
                reduce {
                    state.copy(
                        chatList = state.chatList.toMutableList().apply {
                            add(aiMessage)
                        },
                        isAiTyping = false,
                        chatMessage = ""
                    )
                }
            }

            is ChatScreenEvent.OnMessageChange -> {
                reduce { state.copy(chatMessage = event.message) }
            }
        }
    }
}

object MockedAiChatResponse {
    fun getRandom(): String {
        val responses = listOf(
            "Hello! How can I assist you today?",
            "I'm here to help! What do you need?",
            "Feel free to ask me anything!",
            "I'm ready to chat! What's on your mind?",
            "How can I make your day better?"
        )
        return responses.random()
    }
}
