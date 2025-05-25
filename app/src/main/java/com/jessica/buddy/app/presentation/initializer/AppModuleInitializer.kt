package com.jessica.buddy.app.presentation.initializer

import android.content.Context
import androidx.startup.Initializer
import com.jessica.buddy.app.di.AppModule
import com.jessica.buddy.core.presentation.inititalizer.KoinInitializer
import org.koin.core.context.loadKoinModules
import org.koin.ksp.generated.module

class AppModuleInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        loadKoinModules(AppModule.module)
    }

    override fun dependencies(): List<Class<out Initializer<*>?>?> {
        return listOf(KoinInitializer::class.java)
    }
}
