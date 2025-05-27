package com.jessica.buddy.home.presentation.screen.home

import androidx.lifecycle.ViewModel
import com.jessica.buddy.core.data.local.user.UserLocalDataSource
import org.koin.android.annotation.KoinViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

data class HomeScreenState(
    val name: String,
)

@KoinViewModel
class HomeScreenViewModel(
    userLocalDataSource: UserLocalDataSource
) : ViewModel(), ContainerHost<HomeScreenState, Unit> {
    override val container: Container<HomeScreenState, Unit> = container(
        HomeScreenState(
            name = userLocalDataSource.getUserData().getOrNull()?.userName ?: "Guest"
        )
    )
}
