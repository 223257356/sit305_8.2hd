package com.jessica.buddy.auth.presentation.screen.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jessica.buddy.auth.presentation.screen.login.LoginScreenEvent
import com.jessica.buddy.auth.presentation.screen.login.LoginType
import com.jessica.buddy.core.presentation.component.button.BuddyButton
import com.jessica.buddy.core.presentation.component.button.ButtonType

@Composable
fun MainSignInMenu(
    modifier: Modifier = Modifier,
    onEvent: (LoginScreenEvent) -> Unit = {}
) {
    Column(modifier = modifier.fillMaxWidth()) {
        BuddyButton(
            buttonType = ButtonType.Default(true),
            onClick = {
                onEvent(LoginScreenEvent.DoLogin(LoginType.EMAIL))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        ) {
            Text("Sign In")
        }
        BuddyButton(buttonType = ButtonType.Default(true), onClick = {
            onEvent(LoginScreenEvent.OnCreateAccount)
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Create Account")
        }
    }
}

@Preview
@Composable
private fun MainSignInMenuPreview() {
    MainSignInMenu()
}
