package com.chobo.data.util

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/*class AuthInterceptor @Inject constructor(
    // todo : UserDataStorage
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        val ignorePath = listOf("")
        val ignoreMethod = listOf("")
        // val currentTime = System.currentTimeMillis().
        val path = request.url.encodedPath
        val method = request.method

        ignorePath.forEachIndexed { index, s ->
            if (s == path && ignoreMethod[index] == method)
                return chain.proceed(request)
        }

        return chain.proceed(request)
    }
}*/
class AuthInterceptor @Inject constructor(
    private val authToken: String // todo : UserDataStorage
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
            .header("Authorization", "Bearer $authToken")
            .build()
        return chain.proceed(modifiedRequest)
    }
}