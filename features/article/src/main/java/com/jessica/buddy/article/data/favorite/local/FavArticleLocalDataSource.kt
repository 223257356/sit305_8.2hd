package com.jessica.buddy.article.data.favorite.local

import com.jessica.buddy.core.data.local.LocalDataSource
import kotlinx.serialization.json.Json
import org.koin.core.annotation.Single

interface FavArticleLocalDataSource : GetFavArticleLocalDataSource, SetFavArticleLocalDataSource {
    companion object {
        const val KEY_FAV_ARTICLE = "key_fav_article"
    }
}

@Single
internal class FavArticleLocalDataSourceImpl(
    private val localDataSource: LocalDataSource,
    private val json: Json,
    private val getFavArticleLocalDataSource: GetFavArticleLocalDataSource = GetFavArticleLocalDataSourceImpl(
        localDataSource,
        json
    ),
) : FavArticleLocalDataSource,
    GetFavArticleLocalDataSource by getFavArticleLocalDataSource,
    SetFavArticleLocalDataSource by SetFavArticleLocalDataSourceImpl(
        getFavArticleLocalDataSource,
        localDataSource,
        json
    )
