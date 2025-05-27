package com.jessica.buddy.article.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.jessica.buddy.article.R
import com.jessica.buddy.article.data.model.ArticleData
import com.jessica.buddy.core.presentation.theme.BuddyTheme
import com.ramcosta.composedestinations.generated.article.destinations.ArticleDetailScreenDestination

@Composable
fun ArticleCard(
    data: ArticleData,
    modifier: Modifier = Modifier
) {
    val navigator = BuddyTheme.navigator
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                navigator.navigate(ArticleDetailScreenDestination(data.id))
            },
        shape = RoundedCornerShape(15.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                data.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(130.dp)
                    .padding(end = 16.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.Gray)
            )
            Text(
                data.title,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp),
                style = BuddyTheme.typography.subheader,
                color = BuddyTheme.colors.black
            )

            Icon(
                painter = painterResource(
                    R.drawable.baseline_keyboard_arrow_right_24
                ),
                modifier = Modifier.size(45.dp),
                contentDescription = ""
            )
        }
    }
}

@Composable
@Preview
private fun DailyReadCardPreview() {
    ArticleCard(
        data = ArticleData.mocked().first(),
        modifier = Modifier
    )
}
