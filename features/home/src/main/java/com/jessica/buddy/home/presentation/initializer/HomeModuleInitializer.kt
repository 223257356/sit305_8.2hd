package com.jessica.buddy.home.presentation.initializer

import android.content.Context
import androidx.startup.Initializer
import com.jessica.buddy.core.presentation.inititalizer.KoinInitializer
import com.jessica.buddy.home.di.HomeModule
import org.koin.core.context.loadKoinModules
import org.koin.ksp.generated.module

class HomeModuleInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        loadKoinModules(HomeModule.module)
    }

    override fun dependencies(): List<Class<out Initializer<*>?>?> {
        return listOf(KoinInitializer::class.java)
    }
}
