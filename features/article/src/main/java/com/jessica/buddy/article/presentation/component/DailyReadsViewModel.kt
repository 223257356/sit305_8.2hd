package com.jessica.buddy.article.presentation.component

import androidx.lifecycle.ViewModel
import com.jessica.buddy.article.data.article.ArticleRepository
import com.jessica.buddy.article.data.article.model.ArticleData
import org.koin.android.annotation.KoinViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

data class DailyReadsState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val articles: List<ArticleData> = emptyList()
)

sealed interface DailyReadsUiEvent {
    data class ArticleClick(val article: ArticleData) : DailyReadsUiEvent
}

@KoinViewModel
class DailyReadsViewModel(
    private val articleRepository: ArticleRepository
) : ViewModel(), ContainerHost<DailyReadsState, DailyReadsUiEvent> {
    override val container: Container<DailyReadsState, DailyReadsUiEvent> = container(
        DailyReadsState(),
        onCreate = {
            intent {
                reduce { state.copy(isLoading = true) }
                runCatching {
                    articleRepository.getDailyReads()
                }.onSuccess { articles ->
                    reduce { state.copy(articles = articles, isLoading = false) }
                }.onFailure { throwable ->
                    reduce { state.copy(error = throwable.message, isLoading = false) }
                }
            }
        }
    )

    fun onEvent(event: DailyReadsUiEvent) {
        when (event) {
            is DailyReadsUiEvent.ArticleClick -> {
                intent {
                    // Handle article click event, e.g., navigate to article detail
                    // This can be implemented based on your navigation setup
                }
            }
        }
    }
}
