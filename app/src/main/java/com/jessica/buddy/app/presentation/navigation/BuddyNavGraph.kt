package com.jessica.buddy.app.presentation.navigation

import com.jessica.buddy.core.presentation.navigation.BuddyHostNavigationStyle
import com.ramcosta.composedestinations.annotation.ExternalNavGraph
import com.ramcosta.composedestinations.annotation.NavHostGraph
import com.ramcosta.composedestinations.generated.auth.navgraphs.AuthNavGraph

@NavHostGraph(defaultTransitions = BuddyHostNavigationStyle::class)
annotation class BuddyNavGraph {

    @ExternalNavGraph<AuthNavGraph>
    companion object Includes
}
