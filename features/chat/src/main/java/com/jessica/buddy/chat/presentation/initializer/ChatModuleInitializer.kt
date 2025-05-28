package com.jessica.buddy.chat.presentation.initializer

import android.content.Context
import androidx.startup.Initializer
import com.jessica.buddy.chat.di.ChatModule
import com.jessica.buddy.core.presentation.inititalizer.KoinInitializer
import org.koin.core.context.loadKoinModules
import org.koin.ksp.generated.module

class ChatModuleInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        loadKoinModules(ChatModule.module)
    }

    override fun dependencies(): List<Class<out Initializer<*>?>?> {
        return listOf(KoinInitializer::class.java)
    }
}
