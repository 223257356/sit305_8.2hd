package com.jessica.buddy.chat.presentation.component

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jessica.buddy.core.presentation.theme.BuddyTheme

@Composable
fun AiChatLoading(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text("Buddy", style = BuddyTheme.typography.chatTitle, color = BuddyTheme.colors.black)
        Row(
            Modifier.padding(horizontal = 15.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(3) { index ->
                val animatedAlpha by animateFloatAsState(
                    targetValue = if (remember { Animatable(0.5f) }.value == 0.5f) 1f else 0.5f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(durationMillis = 600)
                    ),
                    label = ""
                )

                Box(
                    modifier = Modifier
                        .graphicsLayer(alpha = animatedAlpha)
                        .clip(CircleShape)
                        .size(15.dp)
                        .background(BuddyTheme.colors.progress)
                )
            }
        }
    }
}

@Composable
@Preview
private fun AiChatPreview() {
    BuddyTheme {
        AiChatLoading(
            modifier = Modifier.padding(8.dp)
        )
    }
}
