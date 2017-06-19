package com.trevorwhitney.fakevac.nest

import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Service

@Service
class NestDataGateway(
    val nestConfig: NestConfig,
    val httpClient: OkHttpClient
) {
    fun getRootResponse(): RootResponse {
        val request = Request.Builder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .url(nestConfig.rootUrl)
            .build()

        val response = httpClient.newCall(request).execute()
        return RootResponse()
    }
}
