package com.jessica.buddy.article.presentation.initializer

import android.content.Context
import androidx.startup.Initializer
import com.jessica.buddy.article.di.ArticleModule
import com.jessica.buddy.core.presentation.inititalizer.KoinInitializer
import org.koin.core.context.loadKoinModules
import org.koin.ksp.generated.module

class ArticleModuleInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        loadKoinModules(ArticleModule.module)
    }

    override fun dependencies(): List<Class<out Initializer<*>?>?> {
        return listOf(KoinInitializer::class.java)
    }
}
