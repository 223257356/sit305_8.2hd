package com.jessica.buddy.core.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.utils.rememberDestinationsNavigator

@Composable
fun BuddyTheme(
    content: @Composable (NavHostController) -> Unit
) {
    val navController = rememberNavController()
    CompositionLocalProvider(
        LocalBuddyColors provides buddyColors,
        LocalBuddyTypography provides buddyTypography,
        LocalBuddyNavigator provides navController.rememberDestinationsNavigator(),
    ) {
        content(navController)
    }
}

object BuddyTheme {

    val colors: BuddyColors
        @Composable
        @ReadOnlyComposable
        get() = LocalBuddyColors.current

    val typography: BuddyTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalBuddyTypography.current

    val navigator: DestinationsNavigator
        @Composable
        @ReadOnlyComposable
        get() = LocalBuddyNavigator.current
}

private val LocalBuddyColors = staticCompositionLocalOf { buddyColors }

private val buddyColors = BuddyColors(
    primary = Color(0xFF375DFB),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFFF1F7FF),
    onSecondary = Color(0xFF0D082C),
    surface = Color(0xFFF8F8F8),
    onSurface = Color(0xFF33363A),
    background = Color(0xFFF8F4EB),
    progress = Color(0xFFC7DFFF),
    disabled = Color(0xFFDADBD6),
    neutral = Color(0xFFEFF0F6),
)

private val LocalBuddyNavigator =
    compositionLocalOf<DestinationsNavigator> { error("No DestinationsNavigator provided") }

private val LocalBuddyTypography = staticCompositionLocalOf { buddyTypography }

private val buddyTypography = BuddyTypography(
    brandLarge = TextStyle(
        fontFamily = leagueSpartanFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 96.sp,
    ),
    brandSmall = TextStyle(
        fontFamily = leagueSpartanFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
    ),
    buttonLarge = TextStyle(
        fontFamily = helveticaFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    ),
    buttonMedium = TextStyle(
        fontFamily = helveticaFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    ),
    buttonSmall = TextStyle(
        fontFamily = helveticaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    chatTitle = TextStyle(
        fontFamily = sourceSansFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
    ),
    chatMessage = TextStyle(
        fontFamily = sourceSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    header = TextStyle(
        fontFamily = helveticaFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
    ),
    subheader = TextStyle(
        fontFamily = helveticaFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    ),
    articleAuthor = TextStyle(
        fontFamily = sourceSansFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
    ),
    articleTime = TextStyle(
        fontFamily = sourceSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),
    articleBody = TextStyle(
        fontFamily = sourceSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    )
)
