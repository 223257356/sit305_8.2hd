package com.jessica.buddy.home.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module
@ComponentScan(
    "com.jessica.buddy.home.data",
    "com.jessica.buddy.home.domain",
    "com.jessica.buddy.home.presentation",
)
object HomeModule
