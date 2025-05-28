package com.jessica.buddy.chat.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jessica.buddy.chat.data.model.ChatData
import com.jessica.buddy.core.presentation.theme.BuddyTheme

@Composable
fun AiChat(
    chatData: ChatData,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text("Buddy", style = BuddyTheme.typography.chatTitle, color = BuddyTheme.colors.black)
        Text(
            chatData.message,
            style = BuddyTheme.typography.chatMessage,
            color = BuddyTheme.colors.black,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)
        )
    }
}

@Composable
@Preview
private fun AiChatPreview() {
    BuddyTheme {
        AiChat(
            chatData = ChatData(
                id = "1",
                message = "Hello, this is a self chat message!",
                isAi = false
            ),
            modifier = Modifier.padding(8.dp)
        )
    }
}
