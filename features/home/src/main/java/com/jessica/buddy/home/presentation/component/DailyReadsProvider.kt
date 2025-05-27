package com.jessica.buddy.home.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

fun interface DailyReadsProvider {
    @Composable
    fun Content(modifier: Modifier)
}
