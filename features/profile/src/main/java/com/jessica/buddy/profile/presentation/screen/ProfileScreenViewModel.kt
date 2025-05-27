package com.jessica.buddy.profile.presentation.screen

import androidx.lifecycle.ViewModel
import com.jessica.buddy.core.data.local.user.UserLocalDataSource
import com.jessica.buddy.core.data.model.UserData
import com.jessica.buddy.core.presentation.navigation.NavigationEvent
import com.jessica.buddy.core.presentation.navigation.NavigationEventBus
import org.koin.android.annotation.KoinViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

data class ProfileScreenState(
    val userData: UserData? = null
)

sealed interface ProfileScreenEvent {
    data object OnLogoutClick : ProfileScreenEvent, NavigationEvent
}

@KoinViewModel
class ProfileScreenViewModel(
    private val userLocalDataSource: UserLocalDataSource,
    private val navigationEventBus: NavigationEventBus
) : ViewModel(), ContainerHost<ProfileScreenState, ProfileScreenEvent> {
    override val container: Container<ProfileScreenState, ProfileScreenEvent> = container(
        ProfileScreenState(userData = userLocalDataSource.getUserData().getOrNull())
    )

    fun onEvent(event: ProfileScreenEvent) = intent {
        when (event) {
            is ProfileScreenEvent.OnLogoutClick -> {
                userLocalDataSource.clearUserData()
                navigationEventBus.post(event)
            }
        }
    }
}
