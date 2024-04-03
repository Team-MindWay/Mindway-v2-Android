package com.chobo.data.util

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    // todo : UserDataStorage
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val ignorePath = listOf("")
        val ignoreMethod = listOf("")
        // val currentTime = System.currentTimeMillis().
        val path = request.url.encodedPath
        val method = request.method

        ignorePath.forEachIndexed { index, s ->
            if (s == path && ignoreMethod[index] == method)
                return chain.proceed(request)
        }

        // todo

        return chain.proceed(request) // todo
    }
}