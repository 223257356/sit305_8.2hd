package com.jessica.buddy.core.presentation.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.jessica.buddy.core.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val leagueSpartanFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("League Spartan"),
        fontProvider = provider,
    )
)

val sourceSansFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Source Sans 3"),
        fontProvider = provider,
    )
)

val helveticaFontFamily = FontFamily(
    androidx.compose.ui.text.font.Font(R.font.helvetica)
)

data class BuddyTypography(
    val brandLarge: TextStyle = TextStyle.Default,
    val brandSmall: TextStyle = TextStyle.Default,
    val buttonLarge: TextStyle = TextStyle.Default,
    val buttonMedium: TextStyle = TextStyle.Default,
    val buttonSmall: TextStyle = TextStyle.Default,
    val chatTitle: TextStyle = TextStyle.Default,
    val chatMessage: TextStyle = TextStyle.Default,
    val header: TextStyle = TextStyle.Default,
    val subheader: TextStyle = TextStyle.Default,
    val articleAuthor: TextStyle = TextStyle.Default,
    val articleTime: TextStyle = TextStyle.Default,
    val articleBody: TextStyle = TextStyle.Default
)
