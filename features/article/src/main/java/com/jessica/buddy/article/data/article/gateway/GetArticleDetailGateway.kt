package com.jessica.buddy.article.data.article.gateway

import com.jessica.buddy.article.data.favorite.local.FavArticleLocalDataSource
import com.jessica.buddy.article.data.article.model.ArticleData
import com.jessica.buddy.article.data.article.remote.ArticleRemoteApi

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
