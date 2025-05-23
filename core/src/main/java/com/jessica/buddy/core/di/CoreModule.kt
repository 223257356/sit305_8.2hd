package com.jessica.buddy.core.di

import com.jessica.buddy.core.data.remote.KtorfitCreator
import com.jessica.buddy.core.data.util.JsonParserCreator
import de.jensklingenberg.ktorfit.Ktorfit
import kotlinx.serialization.json.Json
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan(
    "com.jessica.buddy.core.data",
    "com.jessica.buddy.core.domain",
    "com.jessica.buddy.core.presentation"
)
object CoreModule {

    @Single
    internal fun provideJson(
        creator: JsonParserCreator
    ): Json {
        return creator.create()
    }

    @Single
    internal fun provideKtorfit(
        creator: KtorfitCreator
    ): Ktorfit {
        return creator.create()
    }
}
