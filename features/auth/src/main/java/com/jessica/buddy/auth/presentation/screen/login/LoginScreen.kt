package com.jessica.buddy.auth.presentation.screen.login

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jessica.buddy.auth.presentation.screen.login.LoginScreenEvent.LoginFailed
import com.jessica.buddy.auth.presentation.screen.login.LoginScreenEvent.LoginSuccess
import com.jessica.buddy.core.presentation.component.button.BuddyButton
import com.jessica.buddy.core.presentation.component.button.ButtonType
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

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
            modifier = Modifier.fillMaxSize()
        ) {
            BuddyButton(
                buttonType = ButtonType.Elevated(true),
                modifier = Modifier.fillMaxWidth(),
                onClick = { onEvent(LoginScreenEvent.DoLogin(LoginType.EMAIL)) }
            ) {
                Text(text = "Login")
            }
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
