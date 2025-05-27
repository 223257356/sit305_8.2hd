package com.jessica.buddy.article.data

import com.jessica.buddy.article.data.gateway.GetArticleDetailGateway
import com.jessica.buddy.article.data.gateway.GetArticleDetailGatewayImpl
import com.jessica.buddy.article.data.gateway.GetDailyReadsGateway
import com.jessica.buddy.article.data.gateway.GetDailyReadsGatewayImpl
import com.jessica.buddy.article.data.local.favorite.FavArticleLocalDataSource
import com.jessica.buddy.article.data.remote.ArticleRemoteApi
import org.koin.core.annotation.Single

interface ArticleRepository : GetDailyReadsGateway, GetArticleDetailGateway

@Single
internal class ArticleRepositoryImpl(
    private val articleRemoteApi: ArticleRemoteApi,
    private val favArticleLocalDataSource: FavArticleLocalDataSource
) : ArticleRepository,
    GetDailyReadsGateway by GetDailyReadsGatewayImpl(
        favArticleLocalDataSource,
        articleRemoteApi
    ),
    GetArticleDetailGateway by GetArticleDetailGatewayImpl(
        favArticleLocalDataSource,
        articleRemoteApi
    )
