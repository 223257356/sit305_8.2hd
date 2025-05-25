package com.jessica.buddy.auth.presentation.screen.login

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jessica.buddy.auth.presentation.navigation.AuthGraph
import com.jessica.buddy.auth.presentation.screen.login.LoginScreenEvent.LoginFailed
import com.jessica.buddy.auth.presentation.screen.login.LoginScreenEvent.LoginSuccess
import com.jessica.buddy.auth.presentation.screen.login.components.MainSignInMenu
import com.jessica.buddy.auth.presentation.screen.login.components.SignInSeparator
import com.jessica.buddy.auth.presentation.screen.login.components.SocialSignInMenu
import com.jessica.buddy.core.presentation.theme.BuddyTheme
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Destination<AuthGraph>(start = true)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginScreenViewModel = koinViewModel()
) {
    val context = LocalContext.current
    val state = viewModel.collectAsState().value
    viewModel.collectSideEffect {
        when (it) {
            is LoginFailed -> Toast.makeText(
                context,
                it.message,
                Toast.LENGTH_SHORT
            ).show()

            is LoginSuccess -> Toast.makeText(
                context,
                "Login Success",
                Toast.LENGTH_SHORT
            ).show()

            else -> Unit
        }
    }
    LoginScreen(state = state, modifier = modifier, onEvent = viewModel::onEvent)
}

@Composable
fun LoginScreen(
    state: LoginScreenState,
    modifier: Modifier = Modifier,
    onEvent: (LoginScreenEvent) -> Unit
) {
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    BuddyTheme.colors.white
                )
        ) {
            Text(
                "Buddy",
                style = BuddyTheme.typography.brandLarge,
                color = BuddyTheme.colors.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        BuddyTheme.colors.background
                    )
                    .padding(vertical = 100.dp),
                textAlign = TextAlign.Center
            )
            MainSignInMenu(
                onEvent = onEvent,
                modifier = Modifier
                    .padding(16.dp)
                    .padding(bottom = 80.dp)
            )
            SignInSeparator(modifier = Modifier.padding(bottom = 16.dp))
            SocialSignInMenu(onEvent = onEvent, modifier = Modifier.padding(16.dp))
        }
        AnimatedVisibility(state.isLoading, modifier = Modifier.size(100.dp)) {
            CircularProgressIndicator()
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen(state = LoginScreenState(), onEvent = {})
}
