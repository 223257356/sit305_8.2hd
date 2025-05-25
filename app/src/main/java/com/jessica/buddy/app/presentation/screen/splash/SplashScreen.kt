package com.jessica.buddy.app.presentation.screen.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jessica.buddy.app.presentation.navigation.BuddyNavGraph
import com.jessica.buddy.core.presentation.theme.BuddyTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.generated.app.navgraphs.BuddyGraph
import com.ramcosta.composedestinations.generated.auth.destinations.LoginScreenDestination
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectSideEffect

@Destination<BuddyNavGraph>(start = true)
@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    viewModel: SplashScreenViewModel = koinViewModel()
) {
    val navigator = BuddyTheme.navigator
    viewModel.collectSideEffect {
        when (it) {
            SplashScreenEvent.NavigateToLogin ->
                navigator.navigate(LoginScreenDestination) {
                    popUpTo(BuddyGraph.startRoute) {
                        inclusive = true
                    }
                }

            SplashScreenEvent.NavigateToHome ->
                navigator.navigate(LoginScreenDestination) {
                    popUpTo(BuddyGraph.startRoute) {
                        inclusive = true
                    }
                }
        }
    }
    SplashScreenContent(modifier)
}

@Composable
private fun SplashScreenContent(
    modifier: Modifier = Modifier
) {
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Buddy", style = BuddyTheme.typography.brandLarge, color = BuddyTheme.colors.primary)
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreenContent()
}
