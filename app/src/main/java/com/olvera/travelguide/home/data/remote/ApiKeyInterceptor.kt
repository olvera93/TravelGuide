package com.olvera.travelguide.home.data.remote

import com.olvera.travelguide.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader("Authorization","Bearer ${BuildConfig.API_KEY}")
        return chain.proceed(request.build())
    }


}