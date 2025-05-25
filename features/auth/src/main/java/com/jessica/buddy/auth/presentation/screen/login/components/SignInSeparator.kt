package com.jessica.buddy.auth.presentation.screen.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jessica.buddy.core.presentation.theme.BuddyTheme

@Composable
fun SignInSeparator(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = 2.dp,
            color = BuddyTheme.colors.surface
        )
        Text(
            "Or login with",
            style = BuddyTheme.typography.buttonSmall,
            color = BuddyTheme.colors.onSurface
        )
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = 2.dp,
            color = BuddyTheme.colors.surface
        )
    }
}

@Preview
@Composable
private fun SignInSeparatorPreview() {
    SignInSeparator()
}
