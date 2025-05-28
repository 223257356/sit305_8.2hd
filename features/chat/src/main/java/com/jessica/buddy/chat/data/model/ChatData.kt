package com.jessica.buddy.chat.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ChatData(
    val id: String,
    val isAi: Boolean,
    val message: String,
)
