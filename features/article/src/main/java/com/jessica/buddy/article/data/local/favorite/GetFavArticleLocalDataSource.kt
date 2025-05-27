package com.jessica.buddy.article.data.local.favorite

import com.jessica.buddy.article.data.local.favorite.FavArticleLocalDataSource.Companion.KEY_FAV_ARTICLE
import com.jessica.buddy.article.data.model.ArticleData
import com.jessica.buddy.core.data.local.LocalDataSource
import kotlinx.serialization.json.Json

interface GetFavArticleLocalDataSource {
    fun getFavoriteArticle(): Result<List<ArticleData>>
}

internal class GetFavArticleLocalDataSourceImpl(
    private val localDataSource: LocalDataSource,
    private val json: Json
) : GetFavArticleLocalDataSource {
    override fun getFavoriteArticle(): Result<List<ArticleData>> {
        return runCatching {
            val rawData = localDataSource.getString(
                /* key = */
                KEY_FAV_ARTICLE,
                /* defValue = */
                null
            ).orEmpty()
            json.decodeFromString(rawData)
        }
    }
}
