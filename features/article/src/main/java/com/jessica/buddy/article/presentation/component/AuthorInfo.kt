package com.jessica.buddy.article.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.jessica.buddy.article.data.model.ArticleData
import com.jessica.buddy.core.presentation.theme.BuddyTheme

@Composable
fun AuthorInfo(
    artilceData: ArticleData,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        AsyncImage(
            artilceData.authorImage,
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.Gray)
                .size(40.dp),
            contentDescription = null
        )
        Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
            Text(artilceData.author, style = BuddyTheme.typography.articleAuthor)
            Text(artilceData.date, style = BuddyTheme.typography.articleTime)
        }
    }
}

@Composable
@Preview
private fun AuthorInfoPreview() {
    AuthorInfo(
        artilceData = ArticleData.mocked().first(),
        modifier = Modifier
    )
}
