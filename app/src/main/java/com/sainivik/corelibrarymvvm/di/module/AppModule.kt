package com.technorapper.technoraploader.di.module

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.CacheControl
import okhttp3.Interceptor
import java.util.concurrent.TimeUnit


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    fun provideCacheInterceptor(maxDays: Int): Interceptor? {
        return Interceptor { chain ->
            val response = chain.proceed(chain.request())
            val cacheControl: CacheControl = CacheControl.Builder()
                .maxAge(maxDays, TimeUnit.DAYS)
                .build()
            response.newBuilder()
                .header("Cache-Control", cacheControl.toString())
                .build()
        }
    }
}