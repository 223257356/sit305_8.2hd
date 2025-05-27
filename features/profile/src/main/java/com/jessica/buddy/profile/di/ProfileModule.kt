package com.jessica.buddy.profile.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module
@ComponentScan(
    "com.jessica.buddy.profile.data",
    "com.jessica.buddy.profile.domain",
    "com.jessica.buddy.profile.presentation"
)
object ProfileModule
