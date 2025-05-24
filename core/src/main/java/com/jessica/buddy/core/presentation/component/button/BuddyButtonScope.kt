package com.jessica.buddy.core.presentation.component.button

import android.R.attr.contentDescription
import android.R.attr.text
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jessica.buddy.core.presentation.theme.BuddyTheme

@Stable
class BuddyButtonScope(
    private val buttonType: ButtonType
) {
    @Composable
    fun Text(
        text: String,
        modifier: Modifier = Modifier,
    ) {
        val fontStyle = when (buttonType) {
            is ButtonType.Default, is ButtonType.Outlined -> BuddyTheme.typography.buttonSmall
            is ButtonType.Elevated -> BuddyTheme.typography.buttonLarge
        }
        val paddingTop = when (buttonType) {
            is ButtonType.Default, is ButtonType.Outlined -> 4.5.dp
            is ButtonType.Elevated -> 5.5.dp
        }
        val paddingBottom = when (buttonType) {
            is ButtonType.Default, is ButtonType.Outlined -> 2.dp
            is ButtonType.Elevated -> 3.dp
        }
        androidx.compose.material3.Text(
            text = text,
            modifier = modifier.padding(top = paddingTop, bottom = paddingBottom),
            style = fontStyle
        )
    }

    @Composable
    fun Icon(
        @DrawableRes resId: Int,
        modifier: Modifier = Modifier,
    ) {
        androidx.compose.material3.Icon(
            painter = painterResource(resId),
            modifier = modifier,
            contentDescription = ""
        )
    }
}
