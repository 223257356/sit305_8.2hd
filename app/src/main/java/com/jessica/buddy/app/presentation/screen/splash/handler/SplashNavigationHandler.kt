package com.jessica.buddy.app.presentation.screen.splash.handler

import com.jessica.buddy.app.presentation.screen.splash.SplashScreenEvent
import com.jessica.buddy.core.data.local.user.UserLocalDataSource
import org.koin.core.annotation.Factory
import org.orbitmvi.orbit.syntax.Syntax

@Factory
class SplashNavigationHandler(
    private val userPrefGateway: UserLocalDataSource
) {
    suspend fun checkNavigation(
        syntax: Syntax<Unit, SplashScreenEvent>,
    ) {
        val userData = userPrefGateway.getUserData().getOrNull()
        if (userData == null) {
            syntax.postSideEffect(SplashScreenEvent.NavigateToLogin)
        } else {
            syntax.postSideEffect(SplashScreenEvent.NavigateToHome)
        }
    }
}
