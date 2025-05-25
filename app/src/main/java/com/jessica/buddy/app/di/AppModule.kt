package com.jessica.buddy.app.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module
@ComponentScan(
    "com.jessica.buddy.app.presentation"
)
object AppModule
