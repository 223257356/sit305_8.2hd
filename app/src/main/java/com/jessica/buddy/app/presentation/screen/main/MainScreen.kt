package com.jessica.buddy.app.presentation.screen.main

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jessica.buddy.app.presentation.navigation.BuddyNavGraph
import com.jessica.buddy.article.presentation.screen.CollectionScreen
import com.jessica.buddy.core.presentation.component.header.BuddyHeader
import com.jessica.buddy.core.presentation.theme.BuddyTheme
import com.jessica.buddy.home.presentation.screen.home.HomeScreen
import com.jessica.buddy.profile.presentation.screen.ProfileScreen
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Destination<BuddyNavGraph>()
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = koinViewModel()
) {
    val state = viewModel.collectAsState().value
    MainScreenContent(state, modifier, viewModel::onEvent)
}

@Composable
private fun MainScreenContent(
    state: MainScreenState,
    modifier: Modifier = Modifier,
    onEvent: (MainScreenEvent) -> Unit = {}
) {
    Scaffold(modifier.background(BuddyTheme.colors.background), topBar = {
        BuddyHeader("Buddy")
    }, bottomBar = {
        Column {
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 2.dp,
                color = BuddyTheme.colors.black
            )
            NavigationBar(
                containerColor = BuddyTheme.colors.white
            ) {
                state.menuItems.forEachIndexed { i, item ->
                    NavigationBarItem(
                        selected = i == state.selectedPosition,
                        colors = NavigationBarItemDefaults.colors().copy(
                            selectedIndicatorColor = BuddyTheme.colors.primary.copy(alpha = 0.2f),
                        ),
                        icon = {
                            Icon(
                                painterResource(item),
                                contentDescription = ""
                            )
                        },
                        onClick = {
                            onEvent(MainScreenEvent.MenuItemClicked(i))
                        }
                    )
                }
            }
        }
    }) {
        AnimatedContent(
            targetState = state.selectedPosition,
            modifier = Modifier.padding(it)
        ) { position ->
            when (position) {
                2 -> CollectionScreen()
                3 -> ProfileScreen()
                else -> HomeScreen()
            }
        }
    }
}

@Composable
@Preview
private fun MainScreenPreview() {
    BuddyTheme {
        MainScreenContent(state = MainScreenState())
    }
}
