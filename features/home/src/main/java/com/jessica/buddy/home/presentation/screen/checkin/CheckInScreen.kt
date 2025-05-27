package com.jessica.buddy.home.presentation.screen.checkin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jessica.buddy.core.presentation.component.button.BuddyButton
import com.jessica.buddy.core.presentation.component.button.ButtonType
import com.jessica.buddy.core.presentation.component.header.BuddyHeader
import com.jessica.buddy.core.presentation.theme.BuddyTheme
import com.jessica.buddy.home.R
import com.jessica.buddy.home.presentation.navigation.HomeGraph
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.collections.immutable.persistentListOf
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Destination<HomeGraph>()
@Composable
fun CheckInScreen(
    modifier: Modifier = Modifier,
    viewModel: CheckInViewModel = koinViewModel()
) {
    val state = viewModel.collectAsState().value
    val navigator = BuddyTheme.navigator
    viewModel.collectSideEffect {
        if (it is CheckInEvent.OnSubmitCheckIn) {
            navigator.popBackStack()
        }
    }
    CheckInScreenContent(state, modifier, viewModel::onEvent)
}

@Composable
private fun CheckInScreenContent(
    state: CheckInState,
    modifier: Modifier = Modifier,
    onEvent: (CheckInEvent) -> Unit = {}
) {
    Scaffold(modifier.background(BuddyTheme.colors.background), topBar = {
        val navigator = BuddyTheme.navigator
        BuddyHeader("Buddy", onBackClicked = {
            navigator.popBackStack()
        })
    }) {
        Column(
            Modifier
                .padding(it)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "Hello, ${state.userName}!",
                style = BuddyTheme.typography.subheader,
                modifier = Modifier.padding(bottom = 16.dp),
                color = BuddyTheme.colors.black
            )
            Text(
                "Let’s check in",
                style = BuddyTheme.typography.subheader,
                color = BuddyTheme.colors.primary
            )
            Text(
                "How do you feel today?",
                style = BuddyTheme.typography.subheader,
                color = BuddyTheme.colors.black
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                persistentListOf(
                    R.drawable.mood_0,
                    R.drawable.mood_1,
                    R.drawable.mood_2,
                    R.drawable.mood_3,
                    R.drawable.mood_4
                ).forEachIndexed { index, icon ->
                    Icon(
                        painterResource(icon),
                        tint = if (index == state.moodPoint) BuddyTheme.colors.primary else BuddyTheme.colors.black,
                        contentDescription = null,
                        modifier = Modifier
                            .weight(1f)
                            .clickable {
                                onEvent(CheckInEvent.OnMoodPointChange(index))
                            }
                    )
                }
            }
            Text(
                "How many hours did you sleep last night?",
                style = BuddyTheme.typography.subheader,
                color = BuddyTheme.colors.black
            )
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(bottom = 32.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                persistentListOf(
                    "<5",
                    "6",
                    "7",
                    "8",
                    "9+"
                ).forEachIndexed { index, hour ->
                    Text(
                        hour,
                        style = BuddyTheme.typography.brandSmall,
                        color = if (index == state.sleepHours) BuddyTheme.colors.primary else BuddyTheme.colors.black,
                        modifier = Modifier
                            .weight(1f)
                            .clickable {
                                onEvent(CheckInEvent.OnSleepHoursChange(index))
                            }
                    )
                }
            }
            BuddyButton(buttonType = ButtonType.Elevated(state.submitEnabled), onClick = {
                onEvent(CheckInEvent.SubmitCheckIn)
            }, modifier = Modifier.fillMaxWidth()) {
                Text("Next")
            }
        }
    }
}

@Composable
@Preview
private fun CheckInScreenPreview() {
    CheckInScreenContent(
        state = CheckInState()
    )
}
