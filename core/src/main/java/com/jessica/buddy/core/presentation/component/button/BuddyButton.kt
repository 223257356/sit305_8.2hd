package com.jessica.buddy.core.presentation.component.button

import android.R.attr.enabled
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.jessica.buddy.core.presentation.theme.BuddyTheme

@Stable
sealed class ButtonType(open val enabled: Boolean) {
    data class Default(override val enabled: Boolean) : ButtonType(enabled)
    data class Elevated(override val enabled: Boolean) : ButtonType(enabled)
    data class Outlined(override val enabled: Boolean) : ButtonType(enabled)
}

@Composable
fun BuddyButton(
    modifier: Modifier = Modifier,
    buttonType: ButtonType = ButtonType.Default(true),
    onClick: () -> Unit = {},
    scope: BuddyButtonScope = BuddyButtonScope(buttonType),
    content: @Composable BuddyButtonScope.() -> Unit = {}
) {
    val elevation = if (buttonType is ButtonType.Elevated) 8.dp else 0.dp
    val containerColor = if (buttonType is ButtonType.Outlined) {
        BuddyTheme.colors.surface
    } else {
        BuddyTheme.colors.primary
    }
    val contentColor = if (buttonType is ButtonType.Outlined) {
        BuddyTheme.colors.onSecondary
    } else {
        BuddyTheme.colors.onPrimary
    }
    Button(
        onClick,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = elevation,
            hoveredElevation = elevation
        ),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, BuddyTheme.colors.neutral).takeIf {
            buttonType is ButtonType.Outlined
        },
        enabled = buttonType.enabled,
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = containerColor,
            disabledContainerColor = BuddyTheme.colors.disabled,
            contentColor = contentColor,
            disabledContentColor = BuddyTheme.colors.surface
        ),
        modifier = modifier
    ) {
        with(scope) { content() }
    }
}

@Composable
@Preview
internal fun PreviewBuddyButton(
    @PreviewParameter(BuddyButtonPreviewParameterProvider::class) param: Pair<String, ButtonType>
) {
    BuddyTheme {
        BuddyButton(
            buttonType = param.second,
            content = {
                Text(text = param.first)
            },
        )
    }
}
