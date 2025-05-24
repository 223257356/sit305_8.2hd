package com.jessica.buddy.core.presentation.component.button

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

internal class BuddyButtonPreviewParameterProvider : PreviewParameterProvider<Pair<String, ButtonType>> {
    override val values: Sequence<Pair<String, ButtonType>> = sequenceOf(
        "Default Button Enabled" to ButtonType.Default(true),
        "Default Button Disabled" to ButtonType.Default(false),
        "Outlined Button Enabled" to ButtonType.Outlined(true),
        "Outlined Button Disabled" to ButtonType.Outlined(false),
        "Elevated Button Enabled" to ButtonType.Elevated(true),
        "Elevated Button Disabled" to ButtonType.Elevated(false),
    )
}
