package com.jessica.buddy.app.presentation.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jessica.buddy.app.presentation.screen.splash.handler.SplashNavigationHandler
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

sealed interface SplashScreenEvent {
    object NavigateToLogin : SplashScreenEvent
    object NavigateToHome : SplashScreenEvent
}

@KoinViewModel
class SplashScreenViewModel(
    private val navigationHandler: SplashNavigationHandler
) : ViewModel(), ContainerHost<Unit, SplashScreenEvent> {
    override val container: Container<Unit, SplashScreenEvent> = container(Unit, onCreate = {
        viewModelScope.launch { navigationHandler.checkNavigation(this@container) }
    })
}
