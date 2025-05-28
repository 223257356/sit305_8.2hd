package com.jessica.buddy.chat.presentation.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jessica.buddy.chat.data.model.ChatData
import com.jessica.buddy.chat.presentation.component.AiChat
import com.jessica.buddy.chat.presentation.component.AiChatLoading
import com.jessica.buddy.chat.presentation.component.ChatInput
import com.jessica.buddy.chat.presentation.component.SelfChat
import com.jessica.buddy.chat.presentation.navigation.ChatGraph
import com.jessica.buddy.core.presentation.theme.BuddyTheme
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
@Destination<ChatGraph>(start = true)
fun ChatScreen(
    modifier: Modifier = Modifier,
    viewModel: ChatScreenViewModel = koinViewModel()
) {
    val state = viewModel.collectAsState().value
    ChatScreenContent(state, modifier, onEvent = viewModel::onEvent)
}

@Composable
private fun ChatScreenContent(
    state: ChatScreenState,
    modifier: Modifier = Modifier,
    onEvent: (ChatScreenEvent) -> Unit = {}
) {
    Column(
        modifier
            .fillMaxSize()
            .background(BuddyTheme.colors.background)
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
                .clip(RoundedCornerShape(10.dp)),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(state.chatList) {
                if (it.isAi) {
                    Box(
                        contentAlignment = Alignment.BottomStart,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        AiChat(chatData = it)
                    }
                } else {
                    Box(
                        contentAlignment = Alignment.BottomEnd,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        SelfChat(chatData = it)
                    }
                }
            }
        }
        AnimatedVisibility(state.isAiTyping) {
            AiChatLoading()
        }
        ChatInput(
            state.chatMessage,
            onChatChange = {
                onEvent(ChatScreenEvent.OnMessageChange(it))
            },
            onSendClick = {
                onEvent(ChatScreenEvent.SendMessage(state.chatMessage))
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
@Preview
private fun ChatScreenPreview() {
    BuddyTheme {
        ChatScreenContent(
            state = ChatScreenState(
                chatList = listOf(
                    ChatData(id = "1", message = "Hello, how are you?", isAi = false),
                    ChatData(id = "2", message = "I'm fine, thank you!", isAi = true)
                ),
                isAiTyping = false,
                chatMessage = ""
            )
        )
    }
}
