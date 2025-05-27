package com.jessica.buddy.app.presentation.navigation.handler

import com.jessica.buddy.core.presentation.navigation.NavigationEvent
import com.jessica.buddy.profile.presentation.screen.ProfileScreenEvent
import com.ramcosta.composedestinations.generated.app.destinations.MainScreenDestination
import com.ramcosta.composedestinations.generated.auth.destinations.LoginScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

class ProfileScreenNavigationHandler(
    private val navigator: DestinationsNavigator
) : NavigationEventHandler() {

    override val supportedEvents = setOf(
        ProfileScreenEvent.OnLogoutClick
    )

    override fun navigate(event: NavigationEvent) {
        when (event) {
            ProfileScreenEvent.OnLogoutClick -> navigator.navigate(LoginScreenDestination) {
                popUpTo(MainScreenDestination) { inclusive = true }
            }
        }
    }
}
