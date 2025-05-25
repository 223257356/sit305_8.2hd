package com.jessica.buddy.auth.presentation.screen.login

import androidx.lifecycle.ViewModel
import com.jessica.buddy.auth.presentation.screen.login.handler.LoginHandler
import com.jessica.buddy.core.data.model.UserData
import org.koin.android.annotation.KoinViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

enum class LoginType {
    EMAIL, GOOGLE, FACEBOOK, APPLE, PHONE
}

data class LoginScreenState(
    val isLoading: Boolean = false,
    val isLoginSuccess: Boolean = false,
    val errorMsg: String? = null
)

sealed class LoginScreenEvent {
    data class DoLogin(val loginType: LoginType) : LoginScreenEvent()
    data object OnCreateAccount : LoginScreenEvent()
    data class LoginSuccess(val userData: UserData) : LoginScreenEvent()
    data class LoginFailed(val message: String?) : LoginScreenEvent()
}

@KoinViewModel
class LoginScreenViewModel(
    private val loginHandler: LoginHandler
) : ViewModel(), ContainerHost<LoginScreenState, LoginScreenEvent> {
    override val container: Container<LoginScreenState, LoginScreenEvent> =
        container(LoginScreenState())

    fun onEvent(event: LoginScreenEvent) = intent {
        when (event) {
            is LoginScreenEvent.DoLogin -> loginHandler.doLogin(this, event.loginType)
            else -> Unit
        }
    }
}
