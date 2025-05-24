package com.jessica.buddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jessica.buddy.core.presentation.component.button.BuddyButton
import com.jessica.buddy.core.presentation.component.button.ButtonType
import com.jessica.buddy.core.presentation.theme.BuddyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuddyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello $name!",
            style = BuddyTheme.typography.header,
            color = BuddyTheme.colors.primary,
            modifier = modifier
        )
        BuddyButton(buttonType = ButtonType.Outlined(true)) {
            Icon(R.drawable.ic_launcher_foreground)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BuddyTheme {
        Greeting("Android")
    }
}
