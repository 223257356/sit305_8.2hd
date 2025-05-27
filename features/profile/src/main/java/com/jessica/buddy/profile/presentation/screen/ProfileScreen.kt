package com.jessica.buddy.profile.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.jessica.buddy.core.presentation.component.button.BuddyButton
import com.jessica.buddy.core.presentation.component.button.ButtonType
import com.jessica.buddy.core.presentation.theme.BuddyTheme
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileScreenViewModel = koinViewModel()
) {
    val state = viewModel.collectAsState().value
    ProfileScreenContent(
        state = state,
        modifier = modifier,
        onEvent = viewModel::onEvent
    )
}

@Composable
private fun ProfileScreenContent(
    state: ProfileScreenState,
    modifier: Modifier = Modifier,
    onEvent: (ProfileScreenEvent) -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            state.userData?.userName.orEmpty(),
            style = BuddyTheme.typography.brandLarge,
            color = BuddyTheme.colors.primary,
            textAlign = TextAlign.Center
        )
        BuddyButton(buttonType = ButtonType.Elevated(true), onClick = {
            onEvent(ProfileScreenEvent.OnLogoutClick)
        }) {
            Text(text = "Logout")
        }
    }
}

@Composable
@Preview
private fun ProfileScreenPreview() {
    BuddyTheme {
        ProfileScreenContent(
            state = ProfileScreenState()
        )
    }
}
