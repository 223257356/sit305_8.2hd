package com.jessica.buddy.home.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jessica.buddy.core.presentation.component.button.BuddyButton
import com.jessica.buddy.core.presentation.component.button.ButtonType
import com.jessica.buddy.core.presentation.theme.BuddyTheme
import com.jessica.buddy.home.presentation.component.DailyReadsProvider
import com.jessica.buddy.home.presentation.navigation.HomeGraph
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.orbitmvi.orbit.compose.collectAsState

@Destination<HomeGraph>(start = true)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = koinViewModel(),
    dailyReadsProvider: DailyReadsProvider = koinInject()
) {
    val state = viewModel.collectAsState().value
    HomeScreenContent(state, modifier) {
        dailyReadsProvider.Content(Modifier)
    }
}

@Composable
private fun HomeScreenContent(
    state: HomeScreenState,
    modifier: Modifier = Modifier,
    dailyReads: @Composable () -> Unit = { /* Daily Reads content */ }
) {
    Column(
        modifier
            .fillMaxSize()
            .background(BuddyTheme.colors.background)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            "Hi, ${state.name}!",
            style = BuddyTheme.typography.header,
            color = BuddyTheme.colors.primary
        )
        Text(
            "Accept that you deserve a nice life.",
            style = BuddyTheme.typography.subheader,
            color = BuddyTheme.colors.black
        )
        BuddyButton(
            buttonType = ButtonType.Elevated(true),
            modifier = Modifier.padding(bottom = 16.dp).fillMaxWidth()
        ) {
            Text("Start journalling")
        }
        dailyReads()
    }
}

@Composable
@Preview
private fun HomeScreenPreview() {
    HomeScreenContent(
        state = HomeScreenState(name = "Jessica"),
        dailyReads = {
            Text("Daily Reads content goes here")
        }
    )
}
