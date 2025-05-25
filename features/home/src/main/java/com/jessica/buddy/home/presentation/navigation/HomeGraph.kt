package com.jessica.buddy.home.presentation.navigation

import com.jessica.buddy.core.presentation.navigation.BuddyHostNavigationStyle
import com.ramcosta.composedestinations.annotation.ExternalModuleGraph
import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.parameters.CodeGenVisibility

@NavGraph<ExternalModuleGraph>(
    defaultTransitions = BuddyHostNavigationStyle::class,
    visibility = CodeGenVisibility.PUBLIC,
)
internal annotation class HomeGraph
