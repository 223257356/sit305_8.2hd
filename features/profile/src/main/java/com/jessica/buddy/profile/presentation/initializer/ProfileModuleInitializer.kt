package com.jessica.buddy.profile.presentation.initializer

import android.content.Context
import androidx.startup.Initializer
import com.jessica.buddy.core.presentation.inititalizer.KoinInitializer
import com.jessica.buddy.profile.di.ProfileModule
import org.koin.core.context.loadKoinModules
import org.koin.ksp.generated.module

class ProfileModuleInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        loadKoinModules(ProfileModule.module)
    }

    override fun dependencies(): List<Class<out Initializer<*>?>?> {
        return listOf(KoinInitializer::class.java)
    }
}
