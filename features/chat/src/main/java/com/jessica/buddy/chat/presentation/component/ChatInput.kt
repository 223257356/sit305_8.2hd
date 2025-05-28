package com.jessica.buddy.chat.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jessica.buddy.chat.R
import com.jessica.buddy.core.presentation.theme.BuddyTheme

@Composable
fun ChatInput(
    chatInput: String,
    modifier: Modifier = Modifier,
    onChatChange: (String) -> Unit = {},
    onImageClick: () -> Unit = {},
    onSendClick: () -> Unit = {}
) {
    TextField(
        chatInput,
        onValueChange = onChatChange,
        placeholder = { Text("Reply ...", style = BuddyTheme.typography.chatMessage) },
        modifier = modifier,
        singleLine = true,
        maxLines = 1,
        textStyle = BuddyTheme.typography.chatMessage,
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.emoji),
                contentDescription = "Emoji"
            )
        },
        trailingIcon = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.image),
                    contentDescription = "Image",
                    modifier = Modifier
                        .clickable(onClick = onImageClick)
                )
                Box(
                    modifier = Modifier
                        .clickable(onClick = onSendClick)
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(BuddyTheme.colors.primary)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_keyboard_arrow_right_24),
                        contentDescription = "Send",
                        tint = BuddyTheme.colors.onPrimary
                    )
                }
            }
        }
    )
}

@Composable
@Preview
private fun ChatInputPreview() {
    BuddyTheme {
        ChatInput(
            chatInput = "Hello, this is a chat input preview!",
            modifier = Modifier.padding(8.dp)
        )
    }
}
