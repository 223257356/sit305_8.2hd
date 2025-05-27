package com.jessica.buddy.article.data.gateway

import com.jessica.buddy.article.data.local.favorite.FavArticleLocalDataSource
import com.jessica.buddy.article.data.model.ArticleData
import com.jessica.buddy.article.data.remote.ArticleRemoteApi

interface GetArticleDetailGateway {
    suspend fun getArticleDetail(id: String): ArticleData
}

internal class GetArticleDetailGatewayImpl(
    private val favArticleLocalDataSource: FavArticleLocalDataSource,
    private val articleRemoteApi: ArticleRemoteApi
) : GetArticleDetailGateway {

    override suspend fun getArticleDetail(id: String): ArticleData {
        val article = requireNotNull(
            runCatching {
                articleRemoteApi.getArticleData(id)
            }.getOrElse {
                val articles = ArticleData.mocked()
                articles.firstOrNull { it.id == id }
            }
        )
        val favoriteArticles = favArticleLocalDataSource.getFavoriteArticle()
            .getOrDefault(emptyList())
        return if (favoriteArticles.any { it.id == article.id }) {
            article.copy(isFavorite = true)
        } else {
            article
        }
    }
}
