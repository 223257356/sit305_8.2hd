package com.jessica.buddy.home.presentation.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jessica.buddy.core.presentation.theme.BuddyTheme
import com.jessica.buddy.home.presentation.navigation.HomeGraph
import com.ramcosta.composedestinations.annotation.Destination

@Destination<HomeGraph>(start = true)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Home", style = BuddyTheme.typography.brandLarge, color = BuddyTheme.colors.primary)
    }
}
