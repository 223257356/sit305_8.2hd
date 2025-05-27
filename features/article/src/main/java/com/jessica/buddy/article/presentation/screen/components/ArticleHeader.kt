package com.jessica.buddy.article.presentation.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.jessica.buddy.article.data.model.ArticleData
import com.jessica.buddy.core.presentation.theme.BuddyTheme

const val HEADER_HEIGHT = 500

@Composable
fun ArticleHeader(
    article: ArticleData,
    modifier: Modifier = Modifier
) {
    val imageHeightModifier = remember { Modifier.height(HEADER_HEIGHT.dp) }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .then(imageHeightModifier),
        contentAlignment = Alignment.BottomStart
    ) {
        AsyncImage(
            article.imageUrl,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .then(imageHeightModifier),
            contentDescription = null
        )
        Box(
            Modifier
                .fillMaxWidth()
                .size(size = 150.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            BuddyTheme.colors.black.copy(alpha = 0.7f)
                        )
                    )
                )
        )
        Text(
            article.title,
            style = BuddyTheme.typography.header,
            color = BuddyTheme.colors.white,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(36.dp)
        )
    }
}

@Composable
@Preview
private fun ArticleHeaderPreview() {
    ArticleHeader(
        article = ArticleData.mocked().first(),
        modifier = Modifier
    )
}
