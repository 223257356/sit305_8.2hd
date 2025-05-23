package com.jessica.buddy.core.data.remote

import com.jessica.buddy.core.BuildConfig
import org.koin.core.annotation.Single

@Single
internal class BaseUrlProvider {
    fun getBaseUrl(): String {
        return if (BuildConfig.DEBUG) {
            BuildConfig.MOCK_BASE_URL
        } else {
            BuildConfig.PROD_BASE_URL
        }
    }
}
