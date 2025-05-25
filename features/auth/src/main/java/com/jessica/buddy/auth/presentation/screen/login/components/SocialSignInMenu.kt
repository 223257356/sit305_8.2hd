package com.jessica.buddy.auth.presentation.screen.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jessica.buddy.auth.R
import com.jessica.buddy.auth.presentation.screen.login.LoginScreenEvent
import com.jessica.buddy.auth.presentation.screen.login.LoginType
import com.jessica.buddy.core.presentation.component.button.BuddyButton
import com.jessica.buddy.core.presentation.component.button.ButtonType

@Composable
fun SocialSignInMenu(
    modifier: Modifier = Modifier,
    onEvent: (LoginScreenEvent) -> Unit = {}
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        BuddyButton(
            buttonType = ButtonType.Outlined(true),
            onClick = {
                onEvent(LoginScreenEvent.DoLogin(LoginType.GOOGLE))
            },
            modifier = Modifier
                .weight(1f, fill = true)
        ) {
            Icon(R.drawable.google)
        }
        BuddyButton(
            buttonType = ButtonType.Outlined(true),
            onClick = {
                onEvent(LoginScreenEvent.DoLogin(LoginType.FACEBOOK))
            },
            modifier = Modifier
                .weight(1f, fill = true)
        ) {
            Icon(R.drawable.facebook)
        }
        BuddyButton(
            buttonType = ButtonType.Outlined(true),
            onClick = {
                onEvent(LoginScreenEvent.DoLogin(LoginType.APPLE))
            },
            modifier = Modifier
                .weight(1f, fill = true)
        ) {
            Icon(R.drawable.apple)
        }
        BuddyButton(
            buttonType = ButtonType.Outlined(true),
            onClick = {
                onEvent(LoginScreenEvent.DoLogin(LoginType.PHONE))
            },
            modifier = Modifier
                .weight(1f, fill = true)
        ) {
            Icon(R.drawable.phone)
        }
    }
}

@Preview
@Composable
private fun SocialSignInMenuPreview() {
    SocialSignInMenu()
}
