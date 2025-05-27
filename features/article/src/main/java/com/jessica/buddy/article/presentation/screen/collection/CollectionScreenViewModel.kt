package com.jessica.buddy.article.presentation.screen.collection

import androidx.lifecycle.ViewModel
import com.jessica.buddy.article.data.local.favorite.FavArticleLocalDataSource
import com.jessica.buddy.article.data.model.ArticleData
import org.koin.android.annotation.KoinViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

data class CollectionScreenState(
    val articles: List<ArticleData> = emptyList()
)

@KoinViewModel
class CollectionScreenViewModel(
    favArticleLocalDataSource: FavArticleLocalDataSource
) : ViewModel(), ContainerHost<CollectionScreenState, Unit> {
    override val container: Container<CollectionScreenState, Unit> = container(
        CollectionScreenState(
            articles = favArticleLocalDataSource.getFavoriteArticle().getOrDefault(
                emptyList()
            ),
        )
    )
}
