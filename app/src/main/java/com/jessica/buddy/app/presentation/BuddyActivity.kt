package com.jessica.buddy.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jessica.buddy.app.presentation.navigation.NavigationEventBusHandler
import com.jessica.buddy.core.presentation.theme.BuddyTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.generated.app.AppNavGraphs

class BuddyActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuddyTheme { navController ->
                NavigationEventBusHandler()
                DestinationsNavHost(
                    navGraph = AppNavGraphs.buddy,
                    navController = navController
                )
            }
        }
    }
}
