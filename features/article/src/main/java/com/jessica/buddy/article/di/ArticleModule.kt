package com.jessica.buddy.article.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module
@ComponentScan(
    "com.jessica.buddy.article.data",
    "com.jessica.buddy.article.domain",
    "com.jessica.buddy.article.presentation",
)
object ArticleModule
