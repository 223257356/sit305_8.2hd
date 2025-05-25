package com.jessica.buddy.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.jessica.buddy.app.presentation.navigation.handler.LoginScreenNavigationHandler
import com.jessica.buddy.core.presentation.navigation.NavigationEvent
import com.jessica.buddy.core.presentation.navigation.NavigationEventBus
import com.jessica.buddy.core.presentation.theme.BuddyTheme
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.compose.koinInject
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam
import org.koin.core.parameter.parametersOf

@Factory
class NavigationEventHandlerRegistry(
    @InjectedParam navigator: DestinationsNavigator
) {
    private val handlers = listOf(
        LoginScreenNavigationHandler(navigator)
    )

    fun handle(event: NavigationEvent) {
        handlers.firstOrNull { it.canHandle(event) }?.navigate(event)
    }
}

@Composable
fun NavigationEventBusHandler(
    navigator: DestinationsNavigator = BuddyTheme.navigator,
    eventBus: NavigationEventBus = koinInject(),
    navigationEventHandlerRegistry: NavigationEventHandlerRegistry = koinInject {
        parametersOf(navigator)
    }
) {
    LaunchedEffect(Unit) {
        eventBus.collect(navigationEventHandlerRegistry::handle)
    }
}
