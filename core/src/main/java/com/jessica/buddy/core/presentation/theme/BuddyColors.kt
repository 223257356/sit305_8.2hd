package com.jessica.buddy.core.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class BuddyColors(
    val primary: Color = Color.Unspecified,
    val onPrimary: Color = Color.Unspecified,
    val secondary: Color = Color.Unspecified,
    val onSecondary: Color = Color.Unspecified,
    val surface: Color = Color.Unspecified,
    val onSurface: Color = Color.Unspecified,
    val background: Color = Color.Unspecified,
    val progress: Color = Color.Unspecified,
    val disabled: Color = Color.Unspecified,
    val neutral: Color = Color.Unspecified,
    val white: Color = Color.White,
    val black: Color = Color.Black
)
