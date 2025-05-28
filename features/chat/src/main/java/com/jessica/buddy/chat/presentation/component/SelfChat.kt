package com.jessica.buddy.chat.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jessica.buddy.chat.data.model.ChatData
import com.jessica.buddy.core.presentation.theme.BuddyTheme

@Composable
fun SelfChat(
    chatData: ChatData,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        color = BuddyTheme.colors.primary,
        contentColor = BuddyTheme.colors.onPrimary
    ) {
        Box(modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)) {
            Text(
                chatData.message,
                style = BuddyTheme.typography.chatMessage
            )
        }
    }
}

@Composable
@Preview
private fun SelfChatPreview() {
    BuddyTheme {
        SelfChat(
            chatData = ChatData(
                id = "1",
                message = "Hello, this is a self chat message!",
                isAi = false
            ),
            modifier = Modifier.padding(8.dp)
        )
    }
}
