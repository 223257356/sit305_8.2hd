package com.jessica.buddy.core.data.remote

import com.jessica.buddy.core.BuildConfig
import org.koin.core.annotation.Single

@Single
internal class BaseUrlProvider {
    fun getBaseUrl(): String {
        return BuildConfig.BASE_URL
    }
}
