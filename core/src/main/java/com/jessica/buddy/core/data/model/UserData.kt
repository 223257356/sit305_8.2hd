package com.jessica.buddy.core.data.model

import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    val userName: String
) {
    companion object {
        fun mocked() = UserData("Jessica J.")
    }
}
