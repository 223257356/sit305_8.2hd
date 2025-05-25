package com.jessica.buddy.app.presentation.screen.main

import androidx.lifecycle.ViewModel
import com.jessica.buddy.app.R
import org.koin.android.annotation.KoinViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

data class MainScreenState(
    val selectedPosition: Int = 0,
    val menuItems: List<Int> = listOf(
        R.drawable.outline_cabin_24,
        R.drawable.outline_add_comment_24,
        R.drawable.outline_cards_star_24,
        R.drawable.outline_contacts_product_24
    )
)

sealed interface MainScreenEvent {
    data class MenuItemClicked(val index: Int) : MainScreenEvent
}

@KoinViewModel
class MainScreenViewModel : ViewModel(), ContainerHost<MainScreenState, MainScreenEvent> {
    override val container: Container<MainScreenState, MainScreenEvent> =
        container(MainScreenState())

    fun onEvent(event: MainScreenEvent) = intent {
        when (event) {
            is MainScreenEvent.MenuItemClicked -> reduce { state.copy(selectedPosition = event.index) }
        }
    }
}
