package br.com.well.service

import okhttp3.Interceptor
import okhttp3.Response

const val API_KEY_PARAM = "X-Api-Key"

class ParamsInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.newBuilder()
            .build()

        val newRequest = request.newBuilder()
            .url(url)
            .addHeader(API_KEY_PARAM, BuildConfig.API_KEY)
            .build()

        return chain.proceed(newRequest)
    }
}