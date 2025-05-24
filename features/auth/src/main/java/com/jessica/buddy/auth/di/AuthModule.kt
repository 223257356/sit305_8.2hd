package com.jessica.buddy.auth.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module
@ComponentScan(
    "com.jessica.buddy.auth.data",
    "com.jessica.buddy.auth.domain",
    "com.jessica.buddy.auth.presentation"
)
object AuthModule
