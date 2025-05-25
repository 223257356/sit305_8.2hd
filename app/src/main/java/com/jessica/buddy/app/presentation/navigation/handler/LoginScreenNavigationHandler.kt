package com.jessica.buddy.app.presentation.navigation.handler

import com.jessica.buddy.auth.presentation.screen.login.LoginScreenEvent
import com.jessica.buddy.core.presentation.navigation.NavigationEvent
import com.ramcosta.composedestinations.generated.app.destinations.MainScreenDestination
import com.ramcosta.composedestinations.generated.auth.destinations.LoginScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

class LoginScreenNavigationHandler(
    private val navigator: DestinationsNavigator
) : NavigationEventHandler() {

    override val supportedEvents = setOf(
        LoginScreenEvent.NavigateToHome
    )

    override fun navigate(event: NavigationEvent) {
        when (event) {
            is LoginScreenEvent.NavigateToHome -> navigator.navigate(MainScreenDestination) {
                popUpTo(LoginScreenDestination) { inclusive = true }
            }
        }
    }
}
