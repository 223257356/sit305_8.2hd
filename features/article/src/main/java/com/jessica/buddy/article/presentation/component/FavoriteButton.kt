package com.jessica.buddy.article.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.jessica.buddy.article.R
import com.jessica.buddy.core.presentation.theme.BuddyTheme

@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    val icon = remember(isFavorite) {
        if (isFavorite) {
            R.drawable.like
        } else {
            R.drawable.unlike
        }
    }
    FloatingActionButton(
        onClick,
        modifier = modifier,
        shape = CircleShape,
        containerColor = BuddyTheme.colors.primary,
        contentColor = Color.Unspecified
    ) {
        Icon(painterResource(icon), contentDescription = null)
    }
}

@Composable
@Preview
private fun FavoriteButtonPreview() {
    BuddyTheme {
        Row {
            FavoriteButton(isFavorite = true)
            FavoriteButton(isFavorite = false)
        }
    }
}
