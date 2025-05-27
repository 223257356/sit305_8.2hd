package com.jessica.buddy.home.presentation.screen.home

import androidx.lifecycle.ViewModel
import com.jessica.buddy.core.data.local.user.UserLocalDataSource
import com.jessica.buddy.home.data.checkin.local.CheckInLocalDataSource
import org.koin.android.annotation.KoinViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

data class HomeScreenState(
    val name: String,
)

sealed interface HomeScreenEvent {
    data object CheckLastCheckIn : HomeScreenEvent
    data object ShowCheckInPage : HomeScreenEvent
}

@KoinViewModel
class HomeScreenViewModel(
    userLocalDataSource: UserLocalDataSource,
    private val checkInLocalDataSource: CheckInLocalDataSource,
) : ViewModel(), ContainerHost<HomeScreenState, HomeScreenEvent> {
    override val container: Container<HomeScreenState, HomeScreenEvent> = container(
        HomeScreenState(
            name = userLocalDataSource.getUserData().getOrNull()?.userName ?: "Guest"
        ),
        onCreate = {
            onEvent(HomeScreenEvent.CheckLastCheckIn)
        }
    )

    fun onEvent(event: HomeScreenEvent) = intent {
        when (event) {
            HomeScreenEvent.CheckLastCheckIn -> {
                if (checkInLocalDataSource.shouldShowCheckIn()) {
                    postSideEffect(HomeScreenEvent.ShowCheckInPage)
                }
            }

            else -> Unit
        }
    }
}
