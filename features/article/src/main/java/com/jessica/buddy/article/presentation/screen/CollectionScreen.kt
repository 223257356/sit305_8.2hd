package com.jessica.buddy.article.presentation.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jessica.buddy.article.presentation.component.ArticleCard
import com.jessica.buddy.core.presentation.theme.BuddyTheme
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun CollectionScreen(
    modifier: Modifier = Modifier,
    viewModel: CollectionScreenViewModel = koinViewModel()
) {
    val state = viewModel.collectAsState().value
    CollectionScreenContent(
        state = state,
        modifier = modifier
    )
}

@Composable
private fun CollectionScreenContent(
    state: CollectionScreenState,
    modifier: Modifier = Modifier
) {
    AnimatedContent(state.articles, modifier = modifier.fillMaxSize()) { articles ->
        if (articles.isEmpty()) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    "No Collection Found",
                    style = BuddyTheme.typography.subheader,
                    textAlign = TextAlign.Center
                )
            }
        } else {
            LazyColumn(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                items(articles) {
                    ArticleCard(it)
                }
            }
        }
    }
}
