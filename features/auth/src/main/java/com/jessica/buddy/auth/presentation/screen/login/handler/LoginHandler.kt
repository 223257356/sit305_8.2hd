package com.jessica.buddy.auth.presentation.screen.login.handler

import com.jessica.buddy.auth.data.AuthRepository
import com.jessica.buddy.auth.presentation.screen.login.LoginScreenEvent
import com.jessica.buddy.auth.presentation.screen.login.LoginScreenState
import com.jessica.buddy.auth.presentation.screen.login.LoginType
import com.jessica.buddy.core.data.model.UserData
import com.jessica.buddy.core.presentation.navigation.NavigationEventBus
import org.koin.core.annotation.Factory
import org.orbitmvi.orbit.syntax.Syntax

@Factory
class LoginHandler(
    private val authRepository: AuthRepository,
    private val navigationEventBus: NavigationEventBus
) {
    suspend fun doLogin(
        syntax: Syntax<LoginScreenState, LoginScreenEvent>,
        loginType: LoginType
    ): Result<UserData> {
        syntax.reduce { state.copy(isLoading = true, isLoginSuccess = false, errorMsg = null) }
        return authRepository.signIn {
            when (loginType) {
                LoginType.EMAIL -> emailSignIn()
                LoginType.GOOGLE -> googleSignIn()
                LoginType.FACEBOOK -> facebookSignIn()
                LoginType.APPLE -> appleSignIn()
                LoginType.PHONE -> phoneSignIn()
            }
        }.onSuccess {
            syntax.reduce { state.copy(isLoading = false, isLoginSuccess = true) }
            syntax.postSideEffect(LoginScreenEvent.LoginSuccess(it))
            navigationEventBus.post(LoginScreenEvent.NavigateToHome)
        }.onFailure {
            syntax.reduce { state.copy(isLoading = false, errorMsg = it.message) }
            syntax.postSideEffect(LoginScreenEvent.LoginFailed(it.message))
        }
    }
}
