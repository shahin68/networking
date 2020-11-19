package com.shahin.networking.network

import com.shahin.networking.data.sources.search.local.LocalDataSource
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.util.*
import javax.inject.Inject

const val TOKEN_TYPE = "Bearer"

class HttpInterceptor @Inject constructor(
    private val localDataSource: LocalDataSource
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
//        val token = authLocalDataSource.getLocalToken()
        val url = chain.request().url.newBuilder()
            .addQueryParameter("locale", Locale.getDefault().language)
            .build()
        val requestBuilder = chain
            .request()
            .newBuilder()
//        requestBuilder.addHeader("Authorization", "$TOKEN_TYPE $token")
        val newRequest = requestBuilder.url(url).build()
        return try {
            chain.proceed(newRequest)
        } catch (e: Exception) {
            throw IOException(e.message)
        }
    }
}
