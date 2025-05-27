package com.jessica.buddy.article.presentation.screen.detail

import androidx.lifecycle.ViewModel
import com.jessica.buddy.article.data.article.ArticleRepository
import com.jessica.buddy.article.data.favorite.local.FavArticleLocalDataSource
import com.jessica.buddy.article.data.article.model.ArticleData
import org.koin.android.annotation.KoinViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

data class ArticleDetailScreenState(
    val isLoading: Boolean = false,
    val data: ArticleData? = null
)

sealed interface ArticleDetailScreenEvent {
    data class LoadArticle(val articleId: String) : ArticleDetailScreenEvent
    data class OnAddCollection(val article: ArticleData) : ArticleDetailScreenEvent
}

@KoinViewModel
class ArticleDetailScreenViewModel(
    private val articleRepository: ArticleRepository,
    private val favArticleLocalDataSource: FavArticleLocalDataSource
) : ViewModel(), ContainerHost<ArticleDetailScreenState, ArticleDetailScreenEvent> {
    override val container: Container<ArticleDetailScreenState, ArticleDetailScreenEvent> =
        container(
            initialState = ArticleDetailScreenState()
        )

    fun onEvent(event: ArticleDetailScreenEvent) = intent {
        when (event) {
            is ArticleDetailScreenEvent.OnAddCollection -> {
                favArticleLocalDataSource.setFavoriteArticle(event.article)
                reduce {
                    state.copy(
                        data = state.data?.copy(
                            isFavorite = state.data?.isFavorite == false
                        )
                    )
                }
            }

            is ArticleDetailScreenEvent.LoadArticle -> {
                reduce { state.copy(isLoading = true) }
                val article = articleRepository.getArticleDetail(event.articleId)
                reduce { state.copy(data = article, isLoading = false) }
            }
        }
    }
}
