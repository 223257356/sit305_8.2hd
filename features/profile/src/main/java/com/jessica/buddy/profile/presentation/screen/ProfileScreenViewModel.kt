package com.jessica.buddy.profile.presentation.screen

import androidx.lifecycle.ViewModel
import com.jessica.buddy.core.data.local.user.UserLocalDataSource
import com.jessica.buddy.core.data.model.UserData
import org.koin.android.annotation.KoinViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

data class ProfileScreenState(
    val userData: UserData? = null
)

sealed interface ProfileScreenEvent {
    data object OnLogoutClick : ProfileScreenEvent
}

@KoinViewModel
class ProfileScreenViewModel(
    userLocalDataSource: UserLocalDataSource
) : ViewModel(), ContainerHost<ProfileScreenState, ProfileScreenEvent> {
    override val container: Container<ProfileScreenState, ProfileScreenEvent> = container(
        ProfileScreenState(userData = userLocalDataSource.getUserData().getOrNull())
    )

    fun onEvent(event: ProfileScreenEvent) {
        when (event) {
            is ProfileScreenEvent.OnLogoutClick -> {
                // Handle logout logic here
            }
        }
    }
}
