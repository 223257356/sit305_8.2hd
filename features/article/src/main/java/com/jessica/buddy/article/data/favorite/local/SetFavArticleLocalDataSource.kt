package com.jessica.buddy.article.data.favorite.local

import androidx.core.content.edit
import com.jessica.buddy.article.data.favorite.local.FavArticleLocalDataSource.Companion.KEY_FAV_ARTICLE
import com.jessica.buddy.article.data.article.model.ArticleData
import com.jessica.buddy.core.data.local.LocalDataSource
import kotlinx.serialization.json.Json

interface SetFavArticleLocalDataSource {
    fun setFavoriteArticle(article: ArticleData)
}

internal class SetFavArticleLocalDataSourceImpl(
    private val getFavArticleLocalDataSource: GetFavArticleLocalDataSource,
    private val localDataSource: LocalDataSource,
    private val json: Json
) : SetFavArticleLocalDataSource {
    override fun setFavoriteArticle(article: ArticleData) {
        val currentFav = getFavArticleLocalDataSource.getFavoriteArticle()
            .getOrDefault(emptyList())
            .toMutableList()
        currentFav.removeIf { it.id == article.id }
        currentFav.add(article)
        val rawJson = json.encodeToString(currentFav)
        localDataSource.edit { putString(KEY_FAV_ARTICLE, rawJson) }
    }
}
