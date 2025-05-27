package com.jessica.buddy.article.data.article.remote

import com.jessica.buddy.article.data.article.model.ArticleData
import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Query
import org.koin.core.annotation.Single

interface ArticleRemoteApi {
    @GET("v1/article/daily-reads")
    suspend fun getDailyReads(): List<ArticleData>

    @GET("v1/article/data")
    suspend fun getArticleData(
        @Query("id") id: String
    ): ArticleData
}

@Single
internal class ArticleRemoteApiImpl(ktorfit: Ktorfit) :
    ArticleRemoteApi by ktorfit.createArticleRemoteApi()
