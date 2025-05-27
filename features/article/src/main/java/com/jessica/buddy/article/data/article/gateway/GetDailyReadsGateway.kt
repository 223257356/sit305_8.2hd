package com.jessica.buddy.article.data.article.gateway

import com.jessica.buddy.article.data.favorite.local.FavArticleLocalDataSource
import com.jessica.buddy.article.data.article.model.ArticleData
import com.jessica.buddy.article.data.article.remote.ArticleRemoteApi

interface GetDailyReadsGateway {
    suspend fun getDailyReads(): List<ArticleData>
}

internal class GetDailyReadsGatewayImpl(
    private val favArticleLocalDataSource: FavArticleLocalDataSource,
    private val articleRemoteApi: ArticleRemoteApi
) : GetDailyReadsGateway {
    override suspend fun getDailyReads(): List<ArticleData> {
        val favoriteArticles = favArticleLocalDataSource.getFavoriteArticle()
            .getOrDefault(emptyList())
        // TODO: Remove this if already using correct backend
        val dailyReads = runCatching {
            articleRemoteApi.getDailyReads()
        }.getOrElse { ArticleData.mocked() }
        return dailyReads.map { article ->
            if (favoriteArticles.any { it.id == article.id }) {
                article.copy(isFavorite = true)
            } else {
                article
            }
        }.shuffled().take(3)
    }
}
