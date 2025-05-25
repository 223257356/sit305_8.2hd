package com.jessica.buddy.core.presentation.component.header

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jessica.buddy.core.R
import com.jessica.buddy.core.presentation.theme.BuddyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuddyHeader(
    text: String,
    modifier: Modifier = Modifier,
    onBackClicked: (() -> Unit)? = null,
) {
    val endPadding = remember(onBackClicked) {
        if (onBackClicked == null) 0.dp else 32.dp
    }
    TopAppBar(
        modifier = modifier,
        windowInsets = WindowInsets(top = 32.dp, bottom = 16.dp),
        title = {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                style = BuddyTheme.typography.brandSmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = endPadding)
            )
        },
        navigationIcon = {
            AnimatedVisibility(onBackClicked != null) {
                IconButton(onClick = requireNotNull(onBackClicked)) {
                    Icon(
                        painterResource(R.drawable.baseline_arrow_back_24),
                        contentDescription = "Back"
                    )
                }
            }
        },
        colors = TopAppBarColors(
            containerColor = BuddyTheme.colors.primary,
            scrolledContainerColor = BuddyTheme.colors.primary,
            navigationIconContentColor = BuddyTheme.colors.onPrimary,
            titleContentColor = BuddyTheme.colors.onPrimary,
            actionIconContentColor = BuddyTheme.colors.onPrimary
        )
    )
}

@Composable
@Preview
internal fun PreviewBuddyHeader() {
    BuddyTheme {
        BuddyHeader(
            text = "Buddy",
            onBackClicked = { },
        )
    }
}
