package com.jessica.buddy.app.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jessica.buddy.article.presentation.component.DailyReads
import com.jessica.buddy.home.presentation.component.DailyReadsProvider
import org.koin.core.annotation.Single

@Single
class DailyReadsProviderImpl : DailyReadsProvider {

    @Composable
    override fun Content(modifier: Modifier) {
        DailyReads(modifier)
    }
}
