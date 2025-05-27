package com.jessica.buddy.article.presentation.screen.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jessica.buddy.article.data.model.ArticleData
import com.jessica.buddy.article.presentation.component.AuthorInfo
import com.jessica.buddy.article.presentation.component.FavoriteButton
import com.jessica.buddy.article.presentation.navigation.ArticleGraph
import com.jessica.buddy.article.presentation.screen.components.ArticleHeader
import com.jessica.buddy.article.presentation.screen.components.HEADER_HEIGHT
import com.jessica.buddy.core.presentation.theme.BuddyTheme
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Destination<ArticleGraph>(start = true)
@Composable
fun ArticleDetailScreen(
    articleId: String,
    modifier: Modifier = Modifier,
    viewModel: ArticleDetailScreenViewModel = koinViewModel()
) {
    val state = viewModel.collectAsState().value
    LaunchedEffect(articleId) {
        viewModel.onEvent(ArticleDetailScreenEvent.LoadArticle(articleId))
    }
    ArticleDetailScreenContent(state, modifier, viewModel::onEvent)
}

@Composable
private fun ArticleDetailScreenContent(
    state: ArticleDetailScreenState,
    modifier: Modifier = Modifier,
    onEvent: (ArticleDetailScreenEvent) -> Unit = {}
) {
    Scaffold(modifier) {
        Box(Modifier.padding(it)) {
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                state.data?.let { article ->
                    val horizontalPaddingModifier = Modifier.padding(horizontal = 16.dp)
                    ArticleHeader(article)
                    AuthorInfo(article, modifier = horizontalPaddingModifier)
                    Text(
                        article.content,
                        modifier = horizontalPaddingModifier,
                        style = BuddyTheme.typography.articleBody
                    )
                }
            }
            val buttonTopPadding = remember {
                HEADER_HEIGHT - 25
            }
            FavoriteButton(
                state.data?.isFavorite == true,
                onClick = {
                    state.data?.let { article ->
                        onEvent(ArticleDetailScreenEvent.OnAddCollection(article))
                    }
                },
                modifier = Modifier.padding(top = buttonTopPadding.dp, end = 50.dp).align(Alignment.TopEnd)
            )
        }
    }
}

@Composable
@Preview
private fun ArticleDetailScreenPreview() {
    ArticleDetailScreenContent(
        state = ArticleDetailScreenState(
            data = ArticleData.mocked().first()
        ),
        modifier = Modifier
    )
}
