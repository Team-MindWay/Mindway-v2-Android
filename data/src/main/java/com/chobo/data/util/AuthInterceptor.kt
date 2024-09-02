package com.chobo.data.util

import com.chobo.data.BuildConfig
import com.chobo.data.local.datasource.LocalAuthDataSource
import com.chobo.data.remote.dto.auth.response.GAuthLoginResponse
import com.chobo.domain.exception.NeedLoginException
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val dataSource: LocalAuthDataSource
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        val ignorePath = "/api/v2/auth"
        val currentTime = getDate()
        val path = request.url.encodedPath

        if (ignorePath.contains(path)) {
            return chain.proceed(request)
        }

        runBlocking {
            val accessTime = dataSource.getAccessTime().first().replace("\"", "")
            val refreshTime = dataSource.getRefreshTime().first().replace("\"", "")
            val accessToken = dataSource.getAccessToken().first().replace("\"", "")
            val refreshToken = dataSource.getRefreshToken().first().replace("\"", "")

            if (refreshTime == "") return@runBlocking

            if (currentTime.after(refreshTime.toDate())) throw NeedLoginException()

            if (currentTime.after(accessTime.toDate())) {
                val client = OkHttpClient()
                val refreshRequest = Request.Builder()
                    .url(BuildConfig.BASE_URL + "auth")
                    .patch(chain.request().body ?: RequestBody.create(null, byteArrayOf()))
                    .addHeader(name = "refreshToken", value = "Bearer $refreshToken")
                    .build()
                val moshi = Moshi.Builder().build()
                val adapter: JsonAdapter<GAuthLoginResponse> = moshi.adapter(GAuthLoginResponse::class.java)
                val response = client.newCall(refreshRequest).execute()
                if (response.isSuccessful) {
                    val token = adapter.fromJson(response.body!!.string()) ?: throw NeedLoginException()
                    dataSource.setAccessToken(token.accessToken)
                    dataSource.setRefreshToken(token.refreshToken)
                    dataSource.setAccessTime(token.accessTokenExpiresIn)
                    dataSource.setRefreshTime(token.refreshTokenExpiresIn)
                } else throw NeedLoginException()
            } else {
                builder.addHeader(name = "Authorization", value = "Bearer $accessToken")
            }
            builder.header(name = "Authorization", value = "Bearer $accessToken")
        }
        return chain.proceed(builder.build())
    }
}