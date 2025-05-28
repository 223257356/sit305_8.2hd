package com.jessica.buddy.chat.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module
@ComponentScan(
    "com.jessica.buddy.chat.data",
    "com.jessica.buddy.chat.domain",
    "com.jessica.buddy.chat.presentation"
)
object ChatModule
