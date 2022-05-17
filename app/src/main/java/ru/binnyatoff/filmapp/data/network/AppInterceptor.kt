package ru.binnyatoff.filmapp.data.network

import okhttp3.Interceptor
import okhttp3.Response

class AppInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url.newBuilder()
            .addQueryParameter(API_KEY_HEADER, apiKey)
            .build()
        val request = chain.request().newBuilder()
            .url(url)
            .build()
        return chain.proceed(request)
    }

    companion object {
        const val API_KEY_HEADER = "api-key"
    }
}