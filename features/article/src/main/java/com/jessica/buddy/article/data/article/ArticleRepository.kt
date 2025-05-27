package com.jessica.buddy.article.data.article

import com.jessica.buddy.article.data.article.gateway.GetArticleDetailGateway
import com.jessica.buddy.article.data.article.gateway.GetArticleDetailGatewayImpl
import com.jessica.buddy.article.data.article.gateway.GetDailyReadsGateway
import com.jessica.buddy.article.data.article.gateway.GetDailyReadsGatewayImpl
import com.jessica.buddy.article.data.favorite.local.FavArticleLocalDataSource
import com.jessica.buddy.article.data.article.remote.ArticleRemoteApi
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
