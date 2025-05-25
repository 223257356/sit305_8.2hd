package com.jessica.buddy.app.presentation.navigation

import com.jessica.buddy.core.presentation.navigation.BuddyHostNavigationStyle
import com.ramcosta.composedestinations.annotation.ExternalNavGraph
import com.ramcosta.composedestinations.annotation.NavHostGraph
import com.ramcosta.composedestinations.generated.auth.navgraphs.AuthNavGraph
import com.ramcosta.composedestinations.generated.home.navgraphs.HomeNavGraph

@NavHostGraph(defaultTransitions = BuddyHostNavigationStyle::class)
annotation class BuddyNavGraph {

    @ExternalNavGraph<AuthNavGraph>
    @ExternalNavGraph<HomeNavGraph>
    companion object Includes
}
