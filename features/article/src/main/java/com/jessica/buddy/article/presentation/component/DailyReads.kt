package com.jessica.buddy.article.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jessica.buddy.article.data.model.ArticleData
import com.jessica.buddy.core.presentation.theme.BuddyTheme
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun DailyReads(
    modifier: Modifier = Modifier,
    viewModel: DailyReadsViewModel = koinViewModel()
) {
    val state = viewModel.collectAsState().value
    DailyReadsContent(state, modifier, viewModel::onEvent)
}

@Composable
private fun DailyReadsContent(
    state: DailyReadsState,
    modifier: Modifier = Modifier,
    onEvent: (DailyReadsUiEvent) -> Unit = {}
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Text(
            "Daily Reads:",
            style = BuddyTheme.typography.subheader,
            color = BuddyTheme.colors.primary,
        )
        state.articles.forEach {
            ArticleCard(
                data = it,
                onEvent = onEvent
            )
        }
    }
}

@Composable
@Preview
private fun DailyReadsPreview() {
    BuddyTheme {
        DailyReadsContent(
            state = DailyReadsState(
                articles = ArticleData.mocked()
            )
        )
    }
}
